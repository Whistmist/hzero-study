package org.hzero.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.study.api.controller.dto.Accounting25178EntityDto;
import org.hzero.study.app.service.Accounting25178EntityService;
import org.hzero.study.domain.entity.Accounting25178Entity;
import org.hzero.study.domain.repository.Accounting25178EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
/**
 * 核算主体应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-08-20 16:48:13
 */
@Service
public class Accounting25178EntityServiceImpl implements Accounting25178EntityService {
    @Autowired
    private Accounting25178EntityRepository accounting25178EntityRepository;
    /**
     * 获取核算主体分页列表
     *
     * @param accounting25178Entity 核算主体信息
     * @param pageRequest           分页信息
     * @return Page<Accounting25178Entity>
     */
    @Override
    public Page<Accounting25178Entity> list(Accounting25178Entity accounting25178Entity, PageRequest pageRequest) {
        Page<Accounting25178Entity> list = accounting25178EntityRepository.pageAndSort(pageRequest, accounting25178Entity);
        return list;
    }

    /**
     * 获取核算主体明细
     *
     * @param accEntityCode 核算主体代码
     * @return Accounting25178Entity
     */
    @Override
    public Accounting25178EntityDto detail(String accEntityCode) {
        return accounting25178EntityRepository.detailByAccEntityCode(accEntityCode);
       // Accounting25178Entity accounting25178Entity = accounting25178EntityRepository.selectByPrimaryKey(accEntityId);
        //return accounting25178Entity;
    }

    /**
     * 核算主体创建
     *
     * @param accounting25178Entity 核算主体信息
     * @return List<Accounting25178Entity>
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Accounting25178Entity insert(Accounting25178Entity accounting25178Entity) {
        if (accounting25178Entity == null) {
            return null;
        } else {
            accounting25178EntityRepository.insert(accounting25178Entity);
        }
        return accounting25178Entity;
    }

    /**
     * @param lists
     * @Author: heng.huang@hand-china.com
     * @Description 核算主体信息 批量 创建或更新
     * @CreateDate: 2019/8/16
     */
    @Override
    public List<Accounting25178Entity> batchInsertOrUpdate(List<Accounting25178Entity> lists) {
        if(CollectionUtils.isEmpty(lists)){
            return lists;
        }else {
            for (Accounting25178Entity accounting25178Entity:lists) {
                this.insertOrUpdate(accounting25178Entity);
            }
        }
        return lists;
    }

    /**
     * 核算主体创建或更新
     *
     * @param accounting25178Entity 核算主体信息
     * @return Accounting25178Entity
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Accounting25178Entity insertOrUpdate(Accounting25178Entity accounting25178Entity) {
        if (accounting25178Entity == null) {
            return null;
        } else {
            if (accounting25178Entity.getAccEntityId() == null) {
                accounting25178EntityRepository.insertSelective(accounting25178Entity);
            } else {
                Accounting25178Entity accounting25178EntityDb = accounting25178EntityRepository.selectByPrimaryKey(accounting25178Entity);
                Assert.notNull(accounting25178EntityDb, "error.data_not_exists");
                Assert.isTrue(Objects.equals(accounting25178EntityDb.getTenantId(), accounting25178Entity.getTenantId()), "error.data_invalid");
                accounting25178Entity.setObjectVersionNumber(accounting25178EntityDb.getObjectVersionNumber());
                accounting25178EntityRepository.updateByPrimaryKey(accounting25178Entity);
            }
            return accounting25178Entity;
        }
    }

    /**
     * 核算主体删除
     *
     * @param accounting25178Entity 核算主体信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Accounting25178Entity accounting25178Entity) {
            accounting25178EntityRepository.deleteByPrimaryKey(accounting25178Entity);
    }

    /**
     * 核算主体批量删除
     *
     * @param  accounting25178EntityList 核算主体信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Accounting25178Entity> accounting25178EntityList) {
            accounting25178EntityRepository.batchDeleteByPrimaryKey(accounting25178EntityList);
    }

    /**
     * 核算主体模糊查询
     *
     * @param accounting25178EntityDto 核算主体信息Dto
     * @return
     */
    @Override
    public Page<Accounting25178EntityDto> queryAccountingEntity(Accounting25178EntityDto accounting25178EntityDto,PageRequest pageRequest) {
        return accounting25178EntityRepository.queryAccountingEntity(accounting25178EntityDto,pageRequest);
    }

    /**
     * 分页模糊查询 核算主体明细
     *
     * @param accounting25178EntityDto  核算主体
     * @param pageRequest 分页请求
     * @return 分页数据
     */
    @Override
    public Page<Accounting25178EntityDto> pageAccountingEntity(Accounting25178EntityDto accounting25178EntityDto, PageRequest pageRequest) {
        Page<Accounting25178EntityDto> list = accounting25178EntityRepository.pageAccountingEntity(accounting25178EntityDto, pageRequest);
        return list;
    }
}
