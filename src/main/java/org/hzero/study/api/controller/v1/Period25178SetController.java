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
import org.hzero.study.app.service.Period25178SetService;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Period25178Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 会计期 管理 API
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@Api(tags = SwaggerApi25178Config.PERIODSET)
@RestController("period25178SetController.v1")
@RequestMapping("/v1/{organizationId}/period25178-sets")
public class Period25178SetController extends BaseController {

    @Autowired
    private Period25178SetService period25178SetService;

    @ApiOperation(value = "根据会计期代码、会计期名称 获取会计期信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    @GetMapping("queryPeriodSetByCodeAndName")
    public ResponseEntity<Page<Period25178Set>> queryPeriodSetByCodeAndName(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            Period25178Set period25178Set,
            @ApiIgnore @SortDefault(value = Period25178Set.FIELD_PERIOD_SET_ID,direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Period25178Set> list = period25178SetService.queryPeriodSetByCodeAndName(period25178Set,pageRequest);
        return Results.success(list);
    }


    @ApiOperation(value = "获取会计期分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    @GetMapping("list")
    public ResponseEntity<Page<Period25178Set>> list(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            Period25178Set period25178Set,
            @ApiIgnore @SortDefault(value = Period25178Set.FIELD_PERIOD_SET_ID,direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Period25178Set> list = period25178SetService.list(period25178Set, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "获取会计期明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{periodSetId}")
    public ResponseEntity<Period25178Set> detail(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @PathVariable Long periodSetId) {
        Period25178Set period25178Set = period25178SetService.detail(periodSetId);
        return Results.success(period25178Set);
    }

    @ApiOperation(value = "会计期批量创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<Period25178Set>> batchInsertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Period25178Set> period25178SetList) {
        Assert.notNull(period25178SetList, "error.data_invalid");
        SecurityTokenHelper.validTokenIgnoreInsert(period25178SetList);
        for (Period25178Set period25178Set : period25178SetList) {
            period25178Set.setTenantId(tenantId);
            if (period25178Set.getPeriodSetId() == null) {
                this.validObject(period25178Set, new Class[]{Period25178Set.Insert.class});
            } else {
                this.validObject(period25178Set, new Class[]{Period25178Set.Update.class});
            }
        }
        List<Period25178Set> list = period25178SetService.batchInsertOrUpdate(period25178SetList);
        return Results.success(list);
    }

    @ApiOperation(value = "会计期批量删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/batchRemove")
    public ResponseEntity batchRemove(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Period25178Set> period25178SetList) {
        for (Period25178Set period25178Set : period25178SetList) {
            SecurityTokenHelper.validToken(period25178Set);
        }
        period25178SetService.batchRemove(period25178SetList);
        return Results.success();
    }
}
