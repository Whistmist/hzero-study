package org.hzero.study.api.controller.v1;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.hzero.study.app.service.HeaderService;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Company25178;
import org.hzero.study.domain.entity.Header;
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
 * 管理 API
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
@Api(tags = SwaggerApi25178Config.HEADER)
@RestController("headerSiteController.v1")
@RequestMapping("/v1/headers")
public class HeaderController extends BaseController {

    @Autowired
    private HeaderService headerService;


    @ApiOperation(value = "selectByCondition测试用例（获取分页列表）")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/getHeaderDetails")
    public ResponseEntity<Page<Header>> getHeaderDetails(
            Header header,
            @ApiIgnore @SortDefault(value = Header.FIELD_ID,direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Header> list = headerService.getHeaderDetails(header, pageRequest);
        return Results.success(list);
    }


    @ApiOperation(value = "获取分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/list")
    public ResponseEntity<Page<Header>> list(Header header, @ApiIgnore @SortDefault(value = Header.FIELD_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Header> list = headerService.list(header, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "获取明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{id}")
    public ResponseEntity<Header> detail(@PathVariable Long id) {
        Header header = headerService.detail(id);
        return Results.success(header);
    }

    @ApiOperation(value = "批量创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<Header>> batchInsertOrUpdate(@RequestBody List<Header> headerList) {
        Assert.notNull(headerList, "error.data_invalid");
        for (Header header : headerList) {
            if (header.getId() == null) {
                this.validObject(header, new Class[]{Header.Insert.class});
            } else {
                this.validObject(header, new Class[]{Header.Update.class});
            }
        }
        List<Header> list = headerService.batchInsertOrUpdate(headerList);
        return Results.success(list);
    }

    @ApiOperation(value = "批量删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/batchRemove")
    public ResponseEntity<Header> batchRemove(@RequestBody List<Header> headerList) {
        for (Header header : headerList) {
            SecurityTokenHelper.validToken(header);
        }
        headerService.batchRemove(headerList);
        return Results.success();
    }

    @ApiOperation(value = "公司信息导出")
    @ExcelExport(Header.class)
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/export")
    public ResponseEntity<Page<Header>> export(
            ExportParam exportParam, HttpServletResponse httpServletResponse, Header header
            , @ApiIgnore PageRequest pageRequest) {
        return Results.success(headerService.export(pageRequest, header));
    }
}
