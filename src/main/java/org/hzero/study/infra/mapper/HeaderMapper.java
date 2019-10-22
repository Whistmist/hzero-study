package org.hzero.study.infra.mapper;

import org.hzero.study.domain.entity.Header;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * Mapper
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
public interface HeaderMapper extends BaseMapper<Header> {
    /**
     * 查询信息明细
     * @return
     */
    List<Header> selectHeaderDetails();
}
