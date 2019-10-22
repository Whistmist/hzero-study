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
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.study.app.service.Period25178RuleService;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Period25178Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 期间规则 管理 API
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@Api(tags = SwaggerApi25178Config.PERIODRULE)
@RestController("period25178RuleController.v1")
@RequestMapping("/v1/{organizationId}/period25178-rules")
public class Period25178RuleController extends BaseController {

    @Autowired
    private Period25178RuleService period25178RuleService;

    @ApiOperation(value = "获取期间规则分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Period25178Rule>> list(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            Period25178Rule period25178Rule,
            @ApiIgnore @SortDefault(value = Period25178Rule.FIELD_PERIOD_RULE_ID,direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Period25178Rule> list = period25178RuleService.list(period25178Rule, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "获取期间规则明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{periodRuleId}")
    public ResponseEntity<Period25178Rule> detail(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @PathVariable Long periodRuleId) {
        Period25178Rule period25178Rule = period25178RuleService.detail(periodRuleId);
        return Results.success(period25178Rule);
    }

    @ApiOperation(value = "期间规则批量创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("batchInsertOrUpdate/{periodSetId}")
    public ResponseEntity<List<Period25178Rule>> batchInsertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @ApiParam(value = "会计期ID", required = true) @PathVariable("periodSetId") Long periodSetId,
            @RequestBody List<Period25178Rule> period25178RuleList) {
        Assert.notNull(period25178RuleList, "error.data_invalid");
        SecurityTokenHelper.validTokenIgnoreInsert(period25178RuleList);
        for (Period25178Rule period25178Rule : period25178RuleList) {
            period25178Rule.setPeriodSetId(periodSetId);
            period25178Rule.setTenantId(tenantId);
            if (period25178Rule.getPeriodRuleId() == null) {
                this.validObject(period25178Rule, new Class[]{Period25178Rule.Insert.class});
            } else {
                this.validObject(period25178Rule, new Class[]{Period25178Rule.Update.class});
            }
        }
        List<Period25178Rule> list = period25178RuleService.batchInsertOrUpdate(period25178RuleList);
        return Results.success(list);
    }

    @ApiOperation(value = "期间规则批量删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/batchRemove")
    public ResponseEntity batchRemove(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Period25178Rule> period25178RuleList) {
        for (Period25178Rule period25178Rule : period25178RuleList) {
            period25178Rule.setTenantId(tenantId);
            SecurityTokenHelper.validToken(period25178Rule);
        }
        period25178RuleService.batchRemove(period25178RuleList);
        return Results.success();
    }
}

