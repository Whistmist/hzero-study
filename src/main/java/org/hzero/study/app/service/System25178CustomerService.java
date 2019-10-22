package org.hzero.study.app.service;

import java.util.List;

import org.hzero.study.domain.entity.System25178Customer;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * 系统级客户主数据表应用服务
 *
 * @author heng.huang@hand-china.com 2019-10-17 10:43:40
 */
public interface System25178CustomerService {

    /**
     * 获取系统级客户主数据表分页列表
     *
     * @param system25178Customer 系统级客户主数据表信息
     * @param pageRequest 分页信息
     * @return Page<System25178Customer>
     */
    Page<System25178Customer> list(System25178Customer system25178Customer, PageRequest pageRequest);

    /**
     * 获取系统级客户主数据表明细
     *
     * @param customerId 系统级客户主数据表主键Id
     * @return System25178Customer
     */
    System25178Customer detail(Long customerId);

    /**
     * 系统级客户主数据表创建或更新
     *
     * @param system25178Customer 系统级客户主数据表信息
     * @return System25178Customer
     *
     */
    System25178Customer insertOrUpdate(System25178Customer system25178Customer);

    /**
     * 系统级客户主数据表批量创建或更新
     *
     * @param system25178CustomerList 系统级客户主数据表信息集合
     * @return List<System25178Customer>
     */
    List<System25178Customer> batchInsertOrUpdate(List<System25178Customer> system25178CustomerList);

    /**
     * 系统级客户主数据表删除
     *
     * @param system25178Customer 系统级客户主数据表信息
     * @return
     */
    void remove(System25178Customer system25178Customer);

    /**
     * 系统级客户主数据表批量删除
     *
     * @param  system25178CustomerList 系统级客户主数据表信息集合
     * @return
     */
    void batchRemove(List<System25178Customer> system25178CustomerList);
}
