package org.hzero.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.study.app.service.Period25178RuleService;
import org.hzero.study.domain.entity.Period25178Rule;
import org.hzero.study.domain.entity.Period25178Set;
import org.hzero.study.domain.repository.Period25178RuleRepository;
import org.hzero.study.domain.repository.Period25178SetRepository;
import org.hzero.study.infra.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * 期间规则应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@Service
public class Period25178RuleServiceImpl implements Period25178RuleService {
    @Autowired
    private Period25178RuleRepository period25178RuleRepository;
    @Autowired
    private Period25178SetRepository period25178SetRepository;
    /**
     * 获取期间规则分页列表
     *
     * @param period25178Rule 期间规则信息
     * @param pageRequest 分页信息
     * @return Page<Period25178Rule>
     */
    @Override
    public Page<Period25178Rule> list(Period25178Rule period25178Rule, PageRequest pageRequest) {
        Page<Period25178Rule> list = period25178RuleRepository.pageAndSort(pageRequest, period25178Rule);
        return list;
    }

    /**
     * 获取期间规则明细
     *
     * @param periodRuleId 期间规则主键Id
     * @return Period25178Rule
     */
    @Override
    public Period25178Rule detail(Long periodRuleId) {
        Period25178Rule period25178Rule = period25178RuleRepository.selectByPrimaryKey(periodRuleId);
        return period25178Rule;
    }

    /**
     * 期间规则批量创建或更新
     *
     * @param period25178RuleList 期间规则信息集合
     * @return List<Period25178Rule>
     */
    @Override
	@Transactional(rollbackFor = {Exception.class})
    public List<Period25178Rule> batchInsertOrUpdate(List<Period25178Rule> period25178RuleList){
        // list 根据 MonthFrom 排序
        Collections.sort(period25178RuleList, Comparator.comparing(Period25178Rule::getMonthFrom));
        if (CollectionUtils.isEmpty(period25178RuleList)) {
            return null;
        } else {
            this.insertOrUpdate(period25178RuleList.get(0));
            //调整  根据 终止月份 终止日期 获取下一列 起始日期
            String monthAndDay = DateUtil.getMonthAndDay(period25178RuleList.get(0).getMonthTo(), period25178RuleList.get(0).getDateTo());
            for (int i = 1;i <period25178RuleList.size();i++){
                //起始日期
                String temp = period25178RuleList.get(i).getMonthFrom() +"-"+period25178RuleList.get(i).getDateFrom();
                // 不调整
                if(period25178RuleList.get(i).getAdjustmentFlag()==0){
                    // 比对 上一规则的终止日期  与  插入的起始日期
                    if(monthAndDay.equals(temp)){
                        monthAndDay = DateUtil.getMonthAndDay(period25178RuleList.get(i).getMonthTo(), period25178RuleList.get(i).getDateTo());
                        this.insertOrUpdate(period25178RuleList.get(i));
                    }else {
                        throw new CommonException("hzero.study.error.periodRule.timebug");
                    }
                }//  调整
                else {
                    monthAndDay = period25178RuleList.get(i-1).getMonthTo() +"-"+period25178RuleList.get(i-1).getDateTo();
                    String end = period25178RuleList.get(i).getMonthTo() +"-"+period25178RuleList.get(i).getDateTo();
                    // 比对 上一规则的终止日期  与插入的起始日期
                    if(monthAndDay.equals(temp) && temp.equals(end)){
                        monthAndDay = DateUtil.getMonthAndDay(period25178RuleList.get(i).getMonthTo(), period25178RuleList.get(i).getDateTo());
                        this.insertOrUpdate(period25178RuleList.get(i));
                    }else {
                        throw new CommonException("hzero.study.error.periodRule.timebug");
                    }
                }
            }
            return period25178RuleList;
        }
    }

    /**
     * 期间规则创建或更新
     *
     * @param period25178Rule 期间规则信息
     * @return Period25178Rule
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Period25178Rule insertOrUpdate(Period25178Rule period25178Rule) {
        // 同一会计期规则下名称附加不可重复
        Period25178Rule period25178Rule1 = new Period25178Rule();
        period25178Rule1.setPeriodSetId(period25178Rule.getPeriodSetId());
        period25178Rule1.setPeriodAdditionalName(period25178Rule.getPeriodAdditionalName());
        int count = period25178RuleRepository.selectCount(period25178Rule);
        if (null!=period25178Rule.getPeriodRuleId() || count == 0 ) {
            return execute(period25178Rule);
        }else {
            throw new CommonException("hzero.study.error.periodAdditionalName.exists");
        }
    }
    /**
     * 执行  期间规则创建或更新
     *
     * @param period25178Rule 期间规则信息
     * @return Period25178Rule
     */
    @Transactional(rollbackFor = {Exception.class})
    public Period25178Rule execute(Period25178Rule period25178Rule) {
        if (period25178Rule == null) {
            return null;
        } else {
            if (period25178Rule.getPeriodRuleId() == null) {
                // 期间总数限制规则行数
                int count = period25178RuleRepository.selectCount(period25178Rule);
                Period25178Set period25178Set = new Period25178Set();
                period25178Set.setPeriodSetId(period25178Rule.getPeriodSetId());
                Period25178Set dbperiod25178Set1 = period25178SetRepository.selectByPrimaryKey(period25178Set);
                Assert.notNull(dbperiod25178Set1, "error.data_not_exists");
                if(dbperiod25178Set1.getTotalPeriodNum() < 12){
                    //创建规则
                    period25178RuleRepository.insertSelective(period25178Rule);
                    //会计期 期间总数 +1
                    period25178Set = dbperiod25178Set1;
                    period25178Set.setTotalPeriodNum(dbperiod25178Set1.getTotalPeriodNum()+1);
                    period25178Set.setObjectVersionNumber(dbperiod25178Set1.getObjectVersionNumber());
                    period25178SetRepository.updateByPrimaryKey(period25178Set);
                }else{
                    throw new CommonException(" TotalPeriodNum Must Be Less than 12 ");
                }
            } else {
                Period25178Rule period25178RuleDb = period25178RuleRepository.selectByPrimaryKey(period25178Rule);
                Assert.notNull(period25178RuleDb, "error.data_not_exists");
                Assert.isTrue(Objects.equals(period25178RuleDb.getTenantId(), period25178Rule.getTenantId()), "error.data_invalid");
                period25178Rule.setObjectVersionNumber(period25178RuleDb.getObjectVersionNumber());
                period25178RuleRepository.updateByPrimaryKey(period25178Rule);
            }
            return period25178Rule;
        }
    }

    /**
     * 期间规则删除
     *
     * @param period25178Rule 期间规则信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Period25178Rule period25178Rule) {
            period25178RuleRepository.deleteByPrimaryKey(period25178Rule);
    }

    /**
     * 期间规则批量删除
     *
     * @param  period25178RuleList 期间规则信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Period25178Rule> period25178RuleList) {
        period25178RuleRepository.batchDeleteByPrimaryKey(period25178RuleList);
        //会计期 期间总数 减
        Period25178Set period25178Set = new Period25178Set();
        period25178Set.setPeriodSetId(period25178RuleList.get(0).getPeriodSetId());
        Period25178Set dbperiod25178Set1 = period25178SetRepository.selectByPrimaryKey(period25178Set);
        period25178Set = dbperiod25178Set1;
        period25178Set.setTotalPeriodNum(dbperiod25178Set1.getTotalPeriodNum()-period25178RuleList.size());
        period25178Set.setObjectVersionNumber(dbperiod25178Set1.getObjectVersionNumber());
        period25178Set.setTenantId(period25178RuleList.get(0).getTenantId());
        period25178SetRepository.updateByPrimaryKey(period25178Set);
    }

}
