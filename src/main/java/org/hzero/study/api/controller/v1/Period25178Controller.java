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
import org.hzero.study.api.controller.dto.Period25178Dto;
import org.hzero.study.app.service.Period25178Service;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Period25178;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 期间 管理 API
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@Api(tags = SwaggerApi25178Config.PERIOD)
@RestController("period25178Controller.v1")
@RequestMapping("/v1/{organizationId}/period25178s")
public class Period25178Controller extends BaseController {

    @Autowired
    private Period25178Service period25178Service;

    @ApiOperation(value = "获取期间分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Period25178>> list(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            Period25178 period25178,
            @ApiIgnore @SortDefault(value = Period25178.FIELD_PERIOD_ID,direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Period25178> list = period25178Service.list(period25178, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "获取期间明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{periodId}")
    public ResponseEntity<Period25178> detail(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @PathVariable Long periodId) {
        Period25178 period25178 = period25178Service.detail(periodId);
        return Results.success(period25178);
    }

    @ApiOperation(value = "期间创建")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("insert")
    public ResponseEntity<List<Period25178>> insert(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody Period25178Dto period25178Dto) {
        List<Period25178> list = period25178Service.insert(period25178Dto);
        return Results.success(list);
    }

    @ApiOperation(value = "期间创建-111")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("insertPeriod/{periodSetId}")
    public ResponseEntity<List<Period25178>> insertPeriod(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @ApiParam(value = "会计期ID", required = true) @PathVariable("periodSetId") Long periodSetId,
            Long yearFrom,Long yearTo) {
        Map map = new HashMap();
        map.put("tenantId",tenantId);
        map.put("periodSetId",periodSetId);
        map.put("yearFrom",yearFrom);
        map.put("yearTo",yearTo);
        List<Period25178> list = period25178Service.insertPeriod(map);
        return Results.success(list);
    }

}

