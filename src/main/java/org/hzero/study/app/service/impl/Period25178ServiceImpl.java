package org.hzero.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.study.api.controller.dto.Period25178Dto;
import org.hzero.study.app.service.Period25178Service;
import org.hzero.study.domain.entity.Period25178;
import org.hzero.study.domain.entity.Period25178Rule;
import org.hzero.study.domain.entity.Period25178Set;
import org.hzero.study.domain.repository.Period25178Repository;
import org.hzero.study.domain.repository.Period25178RuleRepository;
import org.hzero.study.domain.repository.Period25178SetRepository;
import org.hzero.study.infra.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;

/**
 * 期间应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@Service
public class Period25178ServiceImpl implements Period25178Service {
    @Autowired
    private Period25178Repository period25178Repository;
    @Autowired
    private Period25178SetRepository period25178SetRepository;
    @Autowired
    private Period25178RuleRepository period25178RuleRepository;
    /**
     * 获取期间分页列表
     *
     * @param period25178 期间信息
     * @param pageRequest 分页信息
     * @return Page<Period25178>
     */
    @Override
    public Page<Period25178> list(Period25178 period25178, PageRequest pageRequest) {
        Page<Period25178> list = period25178Repository.pageAndSort(pageRequest, period25178);
        return list;
    }

    /**
     * 获取期间明细
     *
     * @param periodId 期间主键Id
     * @return Period25178
     */
    @Override
    public Period25178 detail(Long periodId) {
        Period25178 period25178 = period25178Repository.selectByPrimaryKey(periodId);
        return period25178;
    }

    /**
     * 期间创建
     *
     * @param period25178Dto 期间信息
     * @return List<Period25178>
     */
    @Override
	@Transactional(rollbackFor = {Exception.class})
    public List<Period25178> insert(Period25178Dto period25178Dto){
        Long yearFrom = period25178Dto.getYearFrom();
        Long yearTo = period25178Dto.getYearTo();
        List<Period25178> list = new ArrayList<Period25178>();
        List<Period25178Rule> period25178RuleList = period25178Dto.getPeriod25178RuleList();
        Long periodSetId = period25178RuleList.get(0).getPeriodSetId();
        Period25178Set period25178Set = period25178SetRepository.selectByPrimaryKey(periodSetId);
        Assert.notNull(period25178Set,"error.data_not_exists");
        for(Long i = yearFrom;i <= yearTo; i++){
            for (Period25178Rule period25178Rule: period25178RuleList) {
                Period25178 period25178 = new Period25178();
                period25178.setInternalPeriodNum(period25178Rule.getPeriodRuleId());
                period25178.setPeriodYear(i);
                period25178.setPeriodNum(period25178Rule.getMonthFrom());
                //期间名称
                String periodName;
                if(period25178Set.getPeriodAdditionalFlag().equals("S")){
                    periodName= i + period25178Rule.getPeriodAdditionalName();
                }else {
                    periodName = period25178Rule.getPeriodAdditionalName() + i;
                }
                period25178.setPeriodName(periodName);
                period25178.setAdjustmentFlag(period25178Rule.getAdjustmentFlag());
                period25178.setInternalPeriodNum(period25178Rule.getPeriodRuleId());
                //拼接时间
                Date startDate = DateUtil.getTime(i, period25178Rule.getMonthFrom(), period25178Rule.getDateFrom());
                /** 判断是否为闰年*/
                GregorianCalendar gregorianCalendar=new GregorianCalendar();
                boolean isLeapYear = gregorianCalendar.isLeapYear(i.intValue());
                Date endDate =null;
                if(isLeapYear &&  period25178Rule.getMonthTo() == 2 && period25178Rule.getDateTo() == 28){
                    endDate = DateUtil.getTime(i, period25178Rule.getMonthTo(), period25178Rule.getDateTo()+1);
                }else {
                    endDate = DateUtil.getTime(i, period25178Rule.getMonthTo(), period25178Rule.getDateTo());
                }
                period25178.setStartDate(startDate);
                period25178.setEndDate(endDate);
                period25178.setQuarterNum(period25178Rule.getQuarterNum());
                period25178.setPeriodSetId(period25178Rule.getPeriodSetId());
                period25178.setTenantId(period25178Rule.getTenantId());
                Period25178 period251781 = this.insertOrUpdate(period25178);
                list.add(period251781);
            }
        }
        return list;
    }

    /**
     * 期间创建或更新
     *
     * @param period25178 期间信息
     * @return Period25178
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Period25178 insertOrUpdate(Period25178 period25178) {
        if (period25178 == null) {
            return null;
        } else {
            if (period25178.getPeriodId() == null) {
                period25178Repository.insertSelective(period25178);
            } else {
                Period25178 period25178Db = period25178Repository.selectByPrimaryKey(period25178);
                Assert.notNull(period25178Db, "error.data_not_exists");
                Assert.isTrue(Objects.equals(period25178Db.getTenantId(), period25178.getTenantId()), "error.data_invalid");
                period25178.setObjectVersionNumber(period25178Db.getObjectVersionNumber());
                period25178Repository.updateByPrimaryKey(period25178);
            }
            return period25178;
        }
    }

    /**
     * 期间删除
     *
     * @param period25178 期间信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Period25178 period25178) {
            period25178Repository.deleteByPrimaryKey(period25178);
    }

    /**
     * 期间批量删除
     *
     * @param  period25178List 期间信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Period25178> period25178List) {
        period25178Repository.batchDeleteByPrimaryKey(period25178List);
    }

    /**
     * 期间创建 修改
     *
     * @param map 期间信息
     * @return Period25178
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public List<Period25178> insertPeriod(Map map) {

        Long periodSetId = (Long)map.get("periodSetId");
        Long yearFrom = (Long)map.get("yearFrom");
        Long yearTo = (Long)map.get("yearTo");
        List<Period25178Rule> lists = period25178RuleRepository.select("periodSetId", periodSetId);
        List<Period25178> list = new ArrayList<Period25178>();
        Period25178 period25178;
        for(Long i=yearFrom;i<=yearTo;i++){
           for(Period25178Rule period25178Rule: lists){
               period25178 = new Period25178();
               period25178.setPeriodSetId(period25178Rule.getPeriodSetId());
               period25178.setPeriodYear(i);
               period25178.setPeriodNum(period25178Rule.getMonthFrom());
               //期间名称
               String periodName;
               if(period25178Rule.getPeriodAdditionalName().equals("S")){
                   periodName= i + period25178Rule.getPeriodAdditionalName();
               }else {
                   periodName = period25178Rule.getPeriodAdditionalName() + i;
               }
               period25178.setPeriodName(periodName);
               period25178.setAdjustmentFlag(period25178Rule.getAdjustmentFlag());
               period25178.setInternalPeriodNum(period25178Rule.getPeriodRuleId());
               Date startDate = DateUtil.getTime(i, period25178Rule.getMonthFrom(), period25178Rule.getDateFrom());
               Date endDate = DateUtil.getTime(i, period25178Rule.getMonthTo(), period25178Rule.getDateTo()+1);
               period25178.setStartDate(startDate);
               period25178.setEndDate(endDate);
               period25178.setQuarterNum(period25178Rule.getQuarterNum());
               period25178.setPeriodSetId(period25178Rule.getPeriodSetId());
               period25178.setTenantId(period25178Rule.getTenantId());
               list.add(period25178);
               Period25178 period251781 = this.insertOrUpdate(period25178);
           }
        }
        return list;
    }
}
