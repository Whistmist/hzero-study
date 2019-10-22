package org.hzero.study.api.controller.v1;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.hzero.study.app.service.System25178CustomerService;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.System25178Customer;
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


/**
 * 系统级客户主数据表 管理 API
 *
 * @author heng.huang@hand-china.com 2019-10-17 10:43:40
 */
@Api(tags = SwaggerApi25178Config.CUSTOMER)
@RestController("system25178CustomerController.v1")
@RequestMapping("/v1/{organizationId}/system25178-customers")
public class System25178CustomerController extends BaseController {

    @Autowired
    private System25178CustomerService system25178CustomerService;

    @ApiOperation(value = "获取系统级客户主数据表分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<System25178Customer>> list(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            System25178Customer system25178Customer, @ApiIgnore @SortDefault(value = System25178Customer.FIELD_CUSTOMER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<System25178Customer> list = system25178CustomerService.list(system25178Customer, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "获取系统级客户主数据表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{customerId}")
    public ResponseEntity<System25178Customer> detail(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @PathVariable Long customerId) {
        System25178Customer system25178Customer = system25178CustomerService.detail(customerId);
        return Results.success(system25178Customer);
    }

    @ApiOperation(value = "系统级客户主数据表批量创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<System25178Customer>> batchInsertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<System25178Customer> system25178CustomerList) {
        Assert.notNull(system25178CustomerList, "error.data_invalid");
        for (System25178Customer system25178Customer : system25178CustomerList) {
            system25178Customer.setTenantId(tenantId);
            if (system25178Customer.getCustomerId() == null) {
                this.validObject(system25178Customer, new Class[]{System25178Customer.Insert.class});
            } else {
                this.validObject(system25178Customer, new Class[]{System25178Customer.Update.class});
            }
        }
        List<System25178Customer> list = system25178CustomerService.batchInsertOrUpdate(system25178CustomerList);
        return Results.success(list);
    }

    @ApiOperation(value = "系统级客户主数据表批量删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/batchRemove")
    public ResponseEntity<?> batchRemove(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<System25178Customer> system25178CustomerList) {
        for (System25178Customer system25178Customer : system25178CustomerList) {
            SecurityTokenHelper.validToken(system25178Customer);
        }
        system25178CustomerService.batchRemove(system25178CustomerList);
        return Results.success();
    }
}
