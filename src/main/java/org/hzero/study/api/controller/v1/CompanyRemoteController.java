package org.hzero.study.api.controller.v1;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Company25134Level;
import org.hzero.study.infra.feign.CompanyRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * <p>
 * -- feign  练习
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-09-09
 */
@Api(tags = SwaggerApi25178Config.COMPANYREMOTE)
@RestController("companyRemoteController.v1")
@RequestMapping("/v1/{organizationId}/company-remote")
public class CompanyRemoteController {
    @Autowired
    private CompanyRemoteService companyRemoteService;

    @ApiOperation(value = "分页查询公司级别")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/pageCompanies")
    public ResponseEntity<Page<Company25134Level>> pageCompany(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @ApiIgnore @SortDefault(value = Company25134Level.FIELD_COMPANY_LEVEL_ID, direction = Sort.Direction.DESC) PageRequest pageRequest,
            Company25134Level company25134Level
    ) {
        Page<Company25134Level> company25134Levels = companyRemoteService.pageCompany(tenantId,pageRequest,company25134Level);
        return Results.success(company25134Levels);
    }

    @ApiOperation("批量删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/branchDelete")
    public ResponseEntity branchDelete(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Company25134Level> list) {
        Company25134Level company25134Level = companyRemoteService.branchDelete(tenantId, list);
        return Results.success(company25134Level);
    }

    @ApiOperation("批量保存或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/branchInsertOrUpdate")
    public ResponseEntity<List<Company25134Level>> branchInsertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Company25134Level> list) {
        Assert.notNull(list, "error.data_invalid");
        SecurityTokenHelper.validTokenIgnoreInsert(list);
        for (Company25134Level company25134Level : list) {
            company25134Level.setTenantId(tenantId);
        }
        List<Company25134Level> company25134Levels = companyRemoteService.branchInsertOrUpdate(tenantId, list);
        return Results.success(company25134Levels);
    }

}
