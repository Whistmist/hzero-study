package org.hzero.study.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.study.domain.entity.Company25178;

/**
 * 公司资源库
 *
 * @author heng.huang@hand-china.com 2019-10-15 09:48:25
 */
public interface Company25178Repository extends BaseRepository<Company25178> {

    Page<Company25178> export(PageRequest pageRequest, Company25178 company25178);
}
