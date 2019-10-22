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
import org.hzero.study.app.service.SetOf25178BookService;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Company25134Level;
import org.hzero.study.domain.entity.SetOf25178Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 账套 管理 API
 *
 * @author heng.huang@hand-china.com 2019-08-21 10:14:16
 */
@Api(tags = SwaggerApi25178Config.SETOFBOOK)
@RestController("setOf25178BookSiteController.v1")
@RequestMapping("/v1/{organizationId}/set-of25178-books")
public class SetOf25178BookController extends BaseController {

    @Autowired
    private SetOf25178BookService setOf25178BookService;

    @ApiOperation(value = "获取账套分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<SetOf25178Book>> list(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            SetOf25178Book setOf25178Book,
            @ApiIgnore @SortDefault(value = Company25134Level.FIELD_COMPANY_LEVEL_ID, direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SetOf25178Book> list = setOf25178BookService.list(setOf25178Book, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "账套批量创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<SetOf25178Book>> batchInsertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<SetOf25178Book> setOf25178BookList) {
        Assert.notNull(setOf25178BookList, "error.data_invalid");
        SecurityTokenHelper.validTokenIgnoreInsert(setOf25178BookList);
        for (SetOf25178Book setOf25178Book : setOf25178BookList) {
            if (setOf25178Book.getSetOfBooksId() == null) {
                this.validObject(setOf25178Book, new Class[]{SetOf25178Book.Insert.class});
            } else {
                this.validObject(setOf25178Book, new Class[]{SetOf25178Book.Update.class});
            }
        }
        List<SetOf25178Book> list = setOf25178BookService.batchInsertOrUpdate(setOf25178BookList);
        return Results.success(list);
    }
}
