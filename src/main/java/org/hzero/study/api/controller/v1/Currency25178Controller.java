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
import org.hzero.study.app.service.Currency25178Service;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Currency25178;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 币种 管理 API
 *
 * @author heng.huang@hand-china.com 2019-08-21 10:14:16
 */
@Api(tags = SwaggerApi25178Config.CURRENCY)
@RestController("Currency25178SiteController.v1")
@RequestMapping("/v1/{organizationId}/25178-currencys")
public class Currency25178Controller extends BaseController {

    @Autowired
    private Currency25178Service currency25178Service;

    @ApiOperation(value = "获取币种分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("list")
    public ResponseEntity<Page<Currency25178>> list(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            Currency25178 currency25178,
            @ApiIgnore @SortDefault(value = Currency25178.FIELD_CURRENCY_ID, direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Currency25178> list = currency25178Service.list(currency25178, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "币种批量创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<Currency25178>> batchInsertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Currency25178> currency25178List) {
        Assert.notNull(currency25178List, "error.data_invalid");
        SecurityTokenHelper.validTokenIgnoreInsert(currency25178List);
        for (Currency25178 currency25178 : currency25178List){
            if (currency25178.getCurrencyId() == null){
                this.validObject(currency25178, new Class[]{Currency25178.Insert.class});
            }else{
                this.validObject(currency25178, new Class[]{Currency25178.Update.class});
            }
        }
        List<Currency25178> list = currency25178Service.batchInsertOrUpdate(currency25178List);
        return Results.success(list);
    }

}
