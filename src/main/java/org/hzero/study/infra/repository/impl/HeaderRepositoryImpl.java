package org.hzero.study.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.study.domain.entity.Header;
import org.hzero.study.domain.repository.HeaderRepository;
import org.hzero.study.infra.mapper.HeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  资源库实现
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
@Component
public class HeaderRepositoryImpl extends BaseRepositoryImpl<Header> implements HeaderRepository {

    @Autowired
    private HeaderMapper headerMapper;

    @Override
    public Page<Header> export(PageRequest pageRequest, Header header) {
        return PageHelper.doPageAndSort(pageRequest, () -> headerMapper.selectHeaderDetails());
    }
}
