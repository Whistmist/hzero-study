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
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.base.BaseConstants;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.study.api.controller.dto.Accounting25178EntityDto;
import org.hzero.study.app.service.Accounting25178EntityService;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Accounting25178Entity;
import org.hzero.study.domain.entity.Company25134Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 核算主体 管理 API
 *
 * @author heng.huang@hand-china.com 2019-08-20 16:48:13
 */
@Api(tags = SwaggerApi25178Config.ACCOUNTINGENTITY)
@RestController("accounting25178EntityController.v1")
@RequestMapping("/v1/{organizationId}/accounting25178-entitys")
public class Accounting25178EntityController extends BaseController {

    @Autowired
    private Accounting25178EntityService accounting25178EntityService;

    @ApiOperation(value = "获取核算主体分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/list")
    public ResponseEntity<Page<Accounting25178Entity>> list(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            Accounting25178Entity accounting25178Entity,
            @ApiIgnore @SortDefault(value = Company25134Level.FIELD_COMPANY_LEVEL_ID, direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Accounting25178Entity> list = accounting25178EntityService.list(accounting25178Entity, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "核算主体模糊查询-111")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    @GetMapping("get")
    public ResponseEntity<Page<Accounting25178EntityDto>> queryAccounting25178Entity(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            Accounting25178EntityDto accounting25178EntityDto,
                    @ApiIgnore @SortDefault(value = Accounting25178EntityDto.ACC_ENTITY_ID,direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Assert.notNull(accounting25178EntityDto, "error.data_invalid");
        return Results.success(accounting25178EntityService.queryAccountingEntity(accounting25178EntityDto,pageRequest));
    }

    @ApiOperation(value = "根据 核算主体代码 查询 核算主体明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    @GetMapping("/{accEntityCode}")
    public ResponseEntity<Accounting25178EntityDto> detail(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @PathVariable String accEntityCode) {
        Accounting25178EntityDto accounting25178EntityDto = accounting25178EntityService.detail(accEntityCode);
        return Results.success(accounting25178EntityDto);
    }

    @ApiOperation(value = "核算主体创建或更新-111")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<Accounting25178Entity>> insertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Accounting25178Entity> lists) {
        Assert.notNull(lists, "error.data_invalid");
        SecurityTokenHelper.validTokenIgnoreInsert(lists);

        for (Accounting25178Entity accounting25178Entity : lists){
            accounting25178Entity.setTenantId(tenantId);
            if (accounting25178Entity.getAccEntityId() == null) {
                this.validObject(accounting25178Entity, new Class[]{Accounting25178Entity.Insert.class});
            } else {
                this.validObject(accounting25178Entity, new Class[]{Accounting25178Entity.Update.class});
            }
        }
        return Results.success(accounting25178EntityService.batchInsertOrUpdate(lists));
    }

    @ApiOperation(value = "分页模糊查询 核算主体明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    @GetMapping("page")
    public ResponseEntity<Page<Accounting25178EntityDto>> pageAccountingEntity(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            Accounting25178EntityDto accounting25178EntityDto,
            @ApiIgnore @SortDefault(value = Accounting25178Entity.FIELD_ACC_ENTITY_CODE,
                    direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Assert.notNull(accounting25178EntityDto, "error.data_invalid");
        return Results.success(accounting25178EntityService.pageAccountingEntity(accounting25178EntityDto,pageRequest));
    }



}
