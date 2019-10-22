package org.hzero.study.infra.mapper;

import org.hzero.study.api.controller.dto.Company25178LevelDto;
import org.hzero.study.domain.entity.Company25178Level;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * 公司级别Mapper
 *
 * @author heng.huang@hand-china.com 2019-08-15 16:31:34
 */
public interface Company25178LevelMapper extends BaseMapper<Company25178Level> {
    /**
     * 模糊查询公司级别
     * @param company25178LevelDto
     * @return
     */
    List<Company25178Level> queryCompanyLevelByCodeAndDescription(Company25178LevelDto company25178LevelDto);
}
