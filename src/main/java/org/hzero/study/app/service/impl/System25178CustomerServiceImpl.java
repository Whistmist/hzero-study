package org.hzero.study.app.service.impl;

import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.hzero.study.app.service.System25178CustomerService;
import org.hzero.study.domain.entity.System25178Customer;
import org.hzero.study.domain.repository.System25178CustomerRepository;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
/**
 * 系统级客户主数据表应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-10-17 10:43:40
 */
@Service
public class System25178CustomerServiceImpl implements System25178CustomerService {
    @Autowired
    private System25178CustomerRepository system25178CustomerRepository;

    /**
     * 获取系统级客户主数据表分页列表
     *
     * @param system25178Customer 系统级客户主数据表信息
     * @param pageRequest 分页信息
     * @return Page<System25178Customer>
     */
    @Override
    public Page<System25178Customer> list(System25178Customer system25178Customer, PageRequest pageRequest) {
        Page<System25178Customer> list = system25178CustomerRepository.pageAndSort(pageRequest, system25178Customer);
        return list;
    }

    /**
     * 获取系统级客户主数据表明细
     *
     * @param customerId 系统级客户主数据表主键Id
     * @return System25178Customer
     */
    @Override
    public System25178Customer detail(Long customerId) {
        System25178Customer system25178Customer = system25178CustomerRepository.selectByPrimaryKey(customerId);
        return system25178Customer;
    }

    /**
     * 系统级客户主数据表批量创建或更新
     *
     * @param system25178CustomerList 系统级客户主数据表信息集合
     * @return List<System25178Customer>
     */
    @Override
	@Transactional(rollbackFor = {Exception.class})
    public List<System25178Customer> batchInsertOrUpdate(List<System25178Customer> system25178CustomerList){
        if (CollectionUtils.isEmpty(system25178CustomerList)) {
            return system25178CustomerList;
        } else {
            for (System25178Customer system25178Customer : system25178CustomerList) {
                this.insertOrUpdate(system25178Customer);
            }
        }
        return system25178CustomerList;
    }

    /**
     * 系统级客户主数据表创建或更新
     *
     * @param system25178Customer 系统级客户主数据表信息
     * @return System25178Customer
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public System25178Customer insertOrUpdate(System25178Customer system25178Customer) {
        if (system25178Customer == null) {
            return null;
        } else {
            if (system25178Customer.getCustomerId() == null) {
                    system25178CustomerRepository.insertSelective(system25178Customer);
            } else {
                System25178Customer system25178CustomerDb = system25178CustomerRepository.selectByPrimaryKey(system25178Customer);
                Assert.notNull(system25178CustomerDb, "error.data_not_exists");
                                    Assert.isTrue(Objects.equals(system25178CustomerDb.getTenantId(), system25178Customer.getTenantId()), "error.data_invalid");
                                    system25178CustomerRepository.updateByPrimaryKey(system25178Customer);
            }
            return system25178Customer;
        }
    }

    /**
     * 系统级客户主数据表删除
     *
     * @param system25178Customer 系统级客户主数据表信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(System25178Customer system25178Customer) {
            system25178CustomerRepository.deleteByPrimaryKey(system25178Customer);
    }

    /**
     * 系统级客户主数据表批量删除
     *
     * @param  system25178CustomerList 系统级客户主数据表信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<System25178Customer> system25178CustomerList) {
            system25178CustomerRepository.batchDeleteByPrimaryKey(system25178CustomerList);

    }
}
