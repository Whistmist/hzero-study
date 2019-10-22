package org.hzero.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.study.app.service.Currency25178Service;
import org.hzero.study.domain.entity.Currency25178;
import org.hzero.study.domain.repository.Currency25178Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
/**
 * 币种应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-08-21 10:14:16
 */
@Service
public class Currency25178ServiceImpl implements Currency25178Service {
    @Autowired
    private Currency25178Repository Currency25178Repository;

    /**
     * 获取币种分页列表
     *
     * @param currency25178 币种信息
     * @param pageRequest 分页信息
     * @return Page<Currency25178>
     */
    @Override
    public Page<Currency25178> list(Currency25178 currency25178, PageRequest pageRequest) {
        Page<Currency25178> list = Currency25178Repository.pageAndSort(pageRequest, currency25178);
        return list;
    }

    /**
     * 获取币种明细
     *
     * @param currencyId 币种主键Id
     * @return Currency25178
     */
    @Override
    public Currency25178 detail(Long currencyId) {
        Currency25178 Currency25178 = Currency25178Repository.selectByPrimaryKey(currencyId);
        return Currency25178;
    }

    /**
     * 币种批量创建或更新
     *
     * @param Currency25178List 币种信息集合
     * @return List<Currency25178>
     */
    @Override
	@Transactional(rollbackFor = {Exception.class})
    public List<Currency25178> batchInsertOrUpdate(List<Currency25178> Currency25178List){
        if (CollectionUtils.isEmpty(Currency25178List)) {
            return Currency25178List;
        } else {
            for (Currency25178 Currency25178 : Currency25178List) {
                this.insertOrUpdate(Currency25178);
            }
        }
        return Currency25178List;
    }

    /**
     * 币种创建或更新
     *
     * @param currency25178 币种信息
     * @return Currency25178
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Currency25178 insertOrUpdate(Currency25178 currency25178) {
        if (currency25178 == null) {
            return null;
        } else {
            if (currency25178.getCurrencyId() == null) {
                    Currency25178Repository.insertSelective(currency25178);
            } else {
                Currency25178 currency25178Db = Currency25178Repository.selectByPrimaryKey(currency25178);
                Assert.notNull(currency25178Db, "error.data_not_exists");
                currency25178.setObjectVersionNumber(currency25178Db.getObjectVersionNumber());
                Currency25178Repository.updateByPrimaryKey(currency25178);
            }
            return currency25178;
        }
    }

    /**
     * 币种删除
     *
     * @param Currency25178 币种信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Currency25178 Currency25178) {
            Currency25178Repository.deleteByPrimaryKey(Currency25178);
    }

    /**
     * 币种批量删除
     *
     * @param  Currency25178List 币种信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Currency25178> Currency25178List) {
            Currency25178Repository.batchDeleteByPrimaryKey(Currency25178List);

    }
}
