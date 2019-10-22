package org.hzero.study.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.study.api.controller.dto.Accounting25178EntityDto;
import org.hzero.study.domain.entity.Accounting25178Entity;

/**
 * 核算主体资源库
 *
 * @author heng.huang@hand-china.com 2019-08-20
 */
public interface Accounting25178EntityRepository extends BaseRepository<Accounting25178Entity> {
    /**
     * 核算主体模糊查询
     *
     * @param accounting25178EntityDto 核算主体信息Dto
     * @return
     */
    Page<Accounting25178EntityDto> queryAccountingEntity(Accounting25178EntityDto accounting25178EntityDto,PageRequest pageRequest);
    /**
     * 核算主体模糊查询
     *
     * @param accEntityCode 核算主体代码
     * @return
     */
    Accounting25178EntityDto detailByAccEntityCode(String accEntityCode);
    /**
     * 分页模糊查询 核算主体明细
     *
     * @param accounting25178EntityDto  核算主体
     * @param pageRequest 分页请求
     * @return 分页数据
     */
    Page<Accounting25178EntityDto> pageAccountingEntity(Accounting25178EntityDto accounting25178EntityDto, PageRequest pageRequest);
}
