package org.hzero.study.api.controller.v1;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.hzero.study.app.service.Company25178Service;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Company25178;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;


/**
 * 公司 管理 API
 *
 * @author heng.huang@hand-china.com 2019-10-15 09:48:25
 */
@Api(tags = SwaggerApi25178Config.COMPANY)
@RestController("company25178Controller.v1")
@RequestMapping("/v1/{organizationId}/company25178s")
public class Company25178Controller extends BaseController {

    @Autowired
    private Company25178Service company25178Service;

    @ApiOperation(value = "获取公司分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Company25178>> list(@ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
                                                   Company25178 company25178, @ApiIgnore @SortDefault(value = Company25178.FIELD_COMPANY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company25178> list = company25178Service.list(company25178, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "获取公司明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{companyId}")
    public ResponseEntity<Company25178> detail(@ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
                                               @PathVariable Long companyId) {
        Company25178 company25178 = company25178Service.detail(companyId);
        return Results.success(company25178);
    }

    @ApiOperation(value = "公司批量创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<Company25178>> batchInsertOrUpdate(@ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
                                                                  @RequestBody List<Company25178> company25178List) {
        Assert.notNull(company25178List, "error.data_invalid");
        for (Company25178 company25178 : company25178List) {
            company25178.setTenantId(tenantId);
            if (company25178.getCompanyId() == null) {
                this.validObject(company25178, new Class[]{Company25178.Insert.class});
            } else {
                this.validObject(company25178, new Class[]{Company25178.Update.class});
            }
        }
        List<Company25178> list = company25178Service.batchInsertOrUpdate(company25178List);
        return Results.success(list);
    }

    @ApiOperation(value = "公司批量删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/batchRemove")
    public ResponseEntity<Company25178> batchRemove(@ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
                                         @RequestBody List<Company25178> company25178List) {
        for (Company25178 company25178 : company25178List) {
            SecurityTokenHelper.validToken(company25178);
        }
        company25178Service.batchRemove(company25178List);
        return Results.success();
    }

    @ApiOperation(value = "公司信息导出")
    @ExcelExport(Company25178.class)
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/export")
    public ResponseEntity<Page<Company25178>> export(ExportParam exportParam, HttpServletResponse httpServletResponse, Company25178 company25178
            , @ApiIgnore PageRequest pageRequest) {
        return Results.success(company25178Service.export(pageRequest, company25178));
    }
}
