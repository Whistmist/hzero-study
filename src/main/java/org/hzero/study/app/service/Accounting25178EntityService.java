package org.hzero.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.study.api.controller.dto.Accounting25178EntityDto;
import org.hzero.study.domain.entity.Accounting25178Entity;

import java.util.List;

/**
 * 核算主体应用服务
 *
 * @author heng.huang@hand-china.com 2019-08-20
 */
public interface Accounting25178EntityService {

    /**
     * 获取核算主体分页列表
     *
     * @param accounting25178Entity 核算主体信息
     * @param pageRequest 分页信息
     * @return Page<Accounting25178Entity>
     */
    Page<Accounting25178Entity> list(Accounting25178Entity accounting25178Entity, PageRequest pageRequest);

    /**
     * 获取核算主体明细insertOrUpdate
     *
     * @param accEntityCode 核算主体主键Id
     * @return Accounting25178Entity
     */
    Accounting25178EntityDto detail(String accEntityCode);

    /**
     * 核算主体创建
     *
     * @param accounting25178Entity 核算主体信息
     * @return Accounting25178Entity
     *
     */
    Accounting25178Entity insert(Accounting25178Entity accounting25178Entity);

    /**
     * @param lists
     * @Author: heng.huang@hand-china.com
     * @Description 核算主体信息 批量 创建或更新
     * @CreateDate: 2019/8/16
     */
    public List<Accounting25178Entity> batchInsertOrUpdate(List<Accounting25178Entity> lists);

    /**
     * 核算主体创建或更新
     *
     * @param accounting25178Entity 核算主体信息
     * @return List<Accounting25178Entity>
     */
    Accounting25178Entity insertOrUpdate(Accounting25178Entity accounting25178Entity);

    /**
     * 核算主体删除
     *
     * @param accounting25178Entity 核算主体信息
     * @return
     */
    void remove(Accounting25178Entity accounting25178Entity);

    /**
     * 核算主体批量删除
     *
     * @param  accounting25178EntityList 核算主体信息集合
     * @return
     */
    void batchRemove(List<Accounting25178Entity> accounting25178EntityList);
    /**
     * 核算主体模糊查询
     *
     * @param  accounting25178EntityDto 核算主体信息Dto
     * @return
     */
    Page<Accounting25178EntityDto> queryAccountingEntity(Accounting25178EntityDto accounting25178EntityDto,PageRequest pageRequest);

    /**
     * 分页模糊查询 核算主体明细
     *
     * @param accounting25178EntityDto
     * @param pageRequest
     * @return
     */
    Page<Accounting25178EntityDto> pageAccountingEntity(Accounting25178EntityDto accounting25178EntityDto, PageRequest pageRequest);
}
