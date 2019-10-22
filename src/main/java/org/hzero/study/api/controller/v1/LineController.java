package org.hzero.study.api.controller.v1;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.hzero.study.app.service.LineService;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Line;
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
 * 管理 API
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
@Api(tags = SwaggerApi25178Config.LINE)
@RestController("lineSiteController.v1")
@RequestMapping("/v1/lines")
public class LineController extends BaseController {

    @Autowired
    private LineService lineService;

    @ApiOperation(value = "获取分页列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Line>> list(Line line, @ApiIgnore @SortDefault(value = Line.FIELD_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Line> list = lineService.list(line, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "获取明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{lineId}")
    public ResponseEntity<Line> detail(@PathVariable Long lineId) {
        Line line = lineService.detail(lineId);
        return Results.success(line);
    }

    @ApiOperation(value = "批量创建或更新")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<Line>> batchInsertOrUpdate(@RequestBody List<Line> lineList) {
        Assert.notNull(lineList, "error.data_invalid");
        for (Line line : lineList) {
            if (line.getLineId() == null) {
                this.validObject(line, new Class[]{Line.Insert.class});
            } else {
                this.validObject(line, new Class[]{Line.Update.class});
            }
        }
        List<Line> list = lineService.batchInsertOrUpdate(lineList);
        return Results.success(list);
    }

    @ApiOperation(value = "批量删除")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping("/batchRemove")
    public ResponseEntity<?> batchRemove(@RequestBody List<Line> lineList) {
        for (Line line : lineList) {
            SecurityTokenHelper.validToken(line);
        }
        lineService.batchRemove(lineList);
        return Results.success();
    }
}
