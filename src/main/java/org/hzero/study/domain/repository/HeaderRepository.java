package org.hzero.study.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.study.domain.entity.Header;

/**
 * 资源库
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
public interface HeaderRepository extends BaseRepository<Header> {

    /**
     * 信息导出
     * @param pageRequest
     * @param header
     * @return
     */
    Page<Header> export(PageRequest pageRequest, Header header);
}
