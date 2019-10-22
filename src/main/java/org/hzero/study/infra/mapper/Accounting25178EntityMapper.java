package org.hzero.study.infra.mapper;

import org.apache.ibatis.annotations.Param;
import org.hzero.study.api.controller.dto.Accounting25178EntityDto;
import org.hzero.study.domain.entity.Accounting25178Entity;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * 核算主体Mapper
 *
 * @author heng.huang@hand-china.com 2019-08-20 16:48:13
 */
public interface Accounting25178EntityMapper extends BaseMapper<Accounting25178Entity> {

    /**
     * 核算主体模糊查询
     *
     * @param accounting25178EntityDto 核算主体信息Dto
     * @return
     */
    List<Accounting25178EntityDto> queryAccountingEntityByconditions(Accounting25178EntityDto accounting25178EntityDto);

    /**
     * 核算主体模糊查询
     *
     * @param accEntityCode 核算主体代码
     * @return
     */
    Accounting25178EntityDto detailByAccEntityCode(@Param("accEntityCode") String accEntityCode);
}
