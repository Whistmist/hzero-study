package org.hzero.study.infra.mapper;

import org.hzero.study.domain.entity.Company25178;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * 公司Mapper
 *
 * @author heng.huang@hand-china.com 2019-10-15 09:48:25
 */
public interface Company25178Mapper extends BaseMapper<Company25178> {

    List<Company25178> queryDetils();

}
