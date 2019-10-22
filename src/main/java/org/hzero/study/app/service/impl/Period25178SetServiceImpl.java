package org.hzero.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.mybatis.common.Criteria;
import org.hzero.mybatis.common.query.Comparison;
import org.hzero.mybatis.common.query.WhereField;
import org.hzero.study.app.service.Period25178SetService;
import org.hzero.study.domain.entity.Period25178Set;
import org.hzero.study.domain.repository.Period25178SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
/**
 * 会计期应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@Service
public class Period25178SetServiceImpl implements Period25178SetService {
    @Autowired
    private Period25178SetRepository period25178SetRepository;

    /**
     * 获取会计期分页列表
     *
     * @param period25178Set 会计期信息
     * @param pageRequest 分页信息
     * @return Page<Period25178Set>
     */
    @Override
    public Page<Period25178Set> list(Period25178Set period25178Set, PageRequest pageRequest) {
        Page<Period25178Set> list = period25178SetRepository.pageAndSort(pageRequest, period25178Set);
        return list;
    }

    /**
     * 获取会计期明细
     *
     * @param periodSetId 会计期主键Id
     * @return Period25178Set
     */
    @Override
    public Period25178Set detail(Long periodSetId) {
        Period25178Set period25178Set = period25178SetRepository.selectByPrimaryKey(periodSetId);
        return period25178Set;
    }

    /**
     * 会计期批量创建或更新
     *
     * @param period25178SetList 会计期信息集合
     * @return List<Period25178Set>
     */
    @Override
	@Transactional(rollbackFor = {Exception.class})
    public List<Period25178Set> batchInsertOrUpdate(List<Period25178Set> period25178SetList){
        if (CollectionUtils.isEmpty(period25178SetList)) {
            return period25178SetList;
        } else {
            for (Period25178Set period25178Set : period25178SetList) {
                this.insertOrUpdate(period25178Set);
            }
        }
        return period25178SetList;
    }

    /**
     * 会计期创建或更新
     *
     * @param period25178Set 会计期信息
     * @return Period25178Set
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Period25178Set insertOrUpdate(Period25178Set period25178Set) {
        if (period25178Set == null) {
            return null;
        } else {
            if (period25178Set.getPeriodSetId() == null) {
                //	期间总数不超过12
                if(period25178Set.getTotalPeriodNum() > 12){
                    throw new CommonException(" TotalPeriodNum Must Be Less than 12 ");
                }

                period25178SetRepository.insertSelective(period25178Set);
            } else {
                Period25178Set period25178SetDb = period25178SetRepository.selectByPrimaryKey(period25178Set);
                Assert.notNull(period25178SetDb,"error.data_not_exists");
                Assert.isTrue(Objects.equals(period25178SetDb.getTenantId(), period25178Set.getTenantId()), "error.data_invalid");
                period25178Set.setObjectVersionNumber(period25178SetDb.getObjectVersionNumber());
                period25178SetRepository.updateByPrimaryKey(period25178Set);
            }
            return period25178Set;
        }
    }

    /**
     * 会计期删除
     *
     * @param period25178Set 会计期信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Period25178Set period25178Set) {
            period25178SetRepository.deleteByPrimaryKey(period25178Set);
    }

    /**
     * 会计期批量删除
     *
     * @param  period25178SetList 会计期信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Period25178Set> period25178SetList) {
            period25178SetRepository.batchDeleteByPrimaryKey(period25178SetList);
    }

    /**
     * 根据会计期代码、会计期名称 获取会计期信息
     *
     * @param period25178Set
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Page<Period25178Set> queryPeriodSetByCodeAndName(Period25178Set period25178Set,PageRequest pageRequest) {
        Criteria criteria = new Criteria();
        criteria.where(
                new WhereField(Period25178Set.FIELD_PERIOD_SET_CODE, Comparison.LIKE),
                new WhereField(Period25178Set.FIELD_PERIOD_SET_NAME, Comparison.LIKE),
                Period25178Set.FIELD_PERIOD_SET_ID
        );
        return PageHelper.doPageAndSort(pageRequest, () -> {
            return period25178SetRepository.selectOptional(period25178Set, criteria);
        });
    }

}
