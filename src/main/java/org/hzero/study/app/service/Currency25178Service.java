package org.hzero.study.app.service;

import java.util.List;

import org.hzero.study.domain.entity.Currency25178;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * 币种应用服务
 *
 * @author heng.huang@hand-china.com 2019-08-21 10:14:16
 */
public interface Currency25178Service {

    /**
     * 获取币种分页列表
     *
     * @param Currency25178 币种信息
     * @param pageRequest 分页信息
     * @return Page<Currency25178>
     */
    Page<Currency25178> list(Currency25178 Currency25178, PageRequest pageRequest);

    /**
     * 获取币种明细
     *
     * @param currencyId 币种主键Id
     * @return Currency25178
     */
    Currency25178 detail(Long currencyId);

    /**
     * 币种创建或更新
     *
     * @param Currency25178 币种信息
     * @return Currency25178
     *
     */
    Currency25178 insertOrUpdate(Currency25178 Currency25178);

    /**
     * 币种批量创建或更新
     *
     * @param Currency25178List 币种信息集合
     * @return List<Currency25178>
     */
    List<Currency25178> batchInsertOrUpdate(List<Currency25178> Currency25178List);

    /**
     * 币种删除
     *
     * @param Currency25178 币种信息
     * @return
     */
    void remove(Currency25178 Currency25178);

    /**
     * 币种批量删除
     *
     * @param  Currency25178List 币种信息集合
     * @return
     */
    void batchRemove(List<Currency25178>  Currency25178List);
}
