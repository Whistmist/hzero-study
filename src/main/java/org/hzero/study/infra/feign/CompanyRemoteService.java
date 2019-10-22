package org.hzero.study.infra.feign;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.study.domain.entity.Company25134Level;
import org.hzero.study.infra.feign.impl.CompanyRemoteServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * -- RemoteService
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-09-05
 */
@FeignClient(
        value = "HZERO-STUDY-25134",
        fallback = CompanyRemoteServiceFallbackImpl.class
)
public interface CompanyRemoteService {

    @GetMapping("/v1/{organizationId}/company25134-levels/pageCompanies")
    public Page<Company25134Level> pageCompany(
            @PathVariable("organizationId") Long tenantId,
            @RequestParam PageRequest pageRequest,
            @RequestParam Company25134Level company25134Level
    );

    @DeleteMapping("/v1/{organizationId}/company25134-levels/deleleteComp")
    public Company25134Level branchDelete(
            @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Company25134Level> list
    );

    @PostMapping("/v1/{organizationId}/company25134-levels/companies")
    public List<Company25134Level> branchInsertOrUpdate(
            @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Company25134Level> list
    );

}
