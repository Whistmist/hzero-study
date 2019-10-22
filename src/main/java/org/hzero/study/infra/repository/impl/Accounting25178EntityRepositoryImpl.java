package org.hzero.study.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.study.api.controller.dto.Accounting25178EntityDto;
import org.hzero.study.domain.entity.Accounting25178Entity;
import org.hzero.study.domain.repository.Accounting25178EntityRepository;
import org.hzero.study.infra.mapper.Accounting25178EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 核算主体 资源库实现
 *
 * @author heng.huang@hand-china.com 2019-08-20 16:48:13
 */
@Component
public class Accounting25178EntityRepositoryImpl extends BaseRepositoryImpl<Accounting25178Entity> implements Accounting25178EntityRepository {
    @Autowired
    private Accounting25178EntityMapper accounting25178EntityMapper;

    /**
     * 核算主体模糊查询
     *
     * @param accounting25178EntityDto 核算主体信息Dto
     * @return
     */
    @Override
    public Page<Accounting25178EntityDto> queryAccountingEntity(Accounting25178EntityDto accounting25178EntityDto,PageRequest pageRequest) {
        return PageHelper.doPageAndSort(pageRequest, () -> {
            return accounting25178EntityMapper.queryAccountingEntityByconditions(accounting25178EntityDto);
        });
    }

    /**
     * 核算主体模糊查询
     *
     * @param accEntityCode 核算主体代码
     * @return
     */
    @Override
    public Accounting25178EntityDto detailByAccEntityCode(String accEntityCode) {
        return accounting25178EntityMapper.detailByAccEntityCode(accEntityCode);
    }

    /**
     * 分页模糊查询 核算主体明细
     *
     * @param accounting25178EntityDto 核算主体
     * @param pageRequest              分页请求
     * @return 分页数据
     */
    @Override
    public Page<Accounting25178EntityDto> pageAccountingEntity(Accounting25178EntityDto accounting25178EntityDto, PageRequest pageRequest) {
        return PageHelper.doPageAndSort(pageRequest, () -> {
            return accounting25178EntityMapper.queryAccountingEntityByconditions(accounting25178EntityDto);
        });
    }
}
