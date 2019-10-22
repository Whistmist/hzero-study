package org.hzero.study.infra.feign.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.study.domain.entity.Company25134Level;
import org.hzero.study.infra.feign.CompanyRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * -- CompanyRemoteServiceFallbackImpl
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-09-05
 */
@Component
public class CompanyRemoteServiceFallbackImpl implements CompanyRemoteService {
    private static final Logger logger = LoggerFactory.getLogger(CompanyRemoteServiceFallbackImpl.class);

    @Override
    public Page<Company25134Level> pageCompany(Long tenantId, PageRequest pageRequest, Company25134Level company25134Level) {
        logger.error("Faild to get Currency name where tenantId = {},company25134Level={}", tenantId, company25134Level);
        return null;
    }

    @Override
    public Company25134Level branchDelete(Long tenantId, List<Company25134Level> list) {
        logger.error("Faild to get Currency name where tenantId = {},List<Company25134Level>={}", tenantId, list);
        return null;
    }

    @Override
    public List<Company25134Level> branchInsertOrUpdate(Long tenantId, List<Company25134Level> list) {
        logger.error("Faild to get Currency name where tenantId = {},List<Company25134Level>={}", tenantId, list);
        return null;
    }
}
