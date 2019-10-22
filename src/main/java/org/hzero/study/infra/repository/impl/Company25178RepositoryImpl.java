package org.hzero.study.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.study.domain.entity.Company25178;
import org.hzero.study.domain.repository.Company25178Repository;
import org.hzero.study.infra.mapper.Company25178Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 公司 资源库实现
 *
 * @author heng.huang@hand-china.com 2019-10-15 09:48:25
 */
@Component
public class Company25178RepositoryImpl extends BaseRepositoryImpl<Company25178> implements Company25178Repository {
    @Autowired
    private Company25178Mapper company25178Mapper;

    /**
     * 公司信息 导出接口
     *
     * @param pageRequest
     * @param company25178
     * @return
     */
    @Override
    public Page<Company25178> export(PageRequest pageRequest, Company25178 company25178) {
        List<Company25178> list = company25178Mapper.queryDetils();
        return PageHelper.doPageAndSort(pageRequest, () -> company25178Mapper.queryDetils());
    }
}
