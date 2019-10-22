package org.hzero.study.api.controller.v1;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.study.app.service.MybatisService;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Company25178Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * <p>
 * -- Mybatis增强组件
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-09-10
 */
@Api(tags = SwaggerApi25178Config.MYBATIS)
@RestController("mybatisController.v1")
@RequestMapping("/v1/mybatis")
public class MybatisController extends BaseController {

    @Autowired
    private MybatisService mybatisService;

    //-------------------   Mybatis增强组件 测试用例  start  -------------------

    @ApiOperation(value = "根据实体中的属性值进行查询，查询条件使用等号")
    @GetMapping("/select")
    public ResponseEntity<Page<Company25178Level>> select(
            Company25178Level company25178Level,
            @ApiIgnore @SortDefault(value = Company25178Level.FIELD_COMPANY_LEVEL_ID, direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company25178Level> list = mybatisService.select(company25178Level, pageRequest);
        return Results.success(list);

    }

    @ApiOperation(value = "根据Condition条件进行查询")
    @GetMapping("/selectByCondition")
    public ResponseEntity<Page<Company25178Level>> selectByCondition(
            Company25178Level company25178Level,
            @ApiIgnore @SortDefault(value = Company25178Level.FIELD_COMPANY_LEVEL_ID, direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company25178Level> list = mybatisService.selectByCondition(company25178Level, pageRequest);
        return Results.success(list);

    }

    @ApiOperation(value = "使用 selectOptional 进行查询")
    @GetMapping("/selectOptional")
    public ResponseEntity<Page<Company25178Level>> selectOptional(
            Company25178Level company25178Level,
            @ApiIgnore @SortDefault(value = Company25178Level.FIELD_COMPANY_LEVEL_ID, direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company25178Level> list = mybatisService.selectOptional(company25178Level, pageRequest);
        return Results.success(list);

    }


















    //-------------------   Mybatis增强组件 测试用例   end   -------------------

    @ApiOperation(value = "获取公司级别分页列表")
    @GetMapping
    public ResponseEntity<Page<Company25178Level>> list(
            Company25178Level company25178Level,
            @ApiIgnore @SortDefault(value = Company25178Level.FIELD_COMPANY_LEVEL_ID, direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company25178Level> list = mybatisService.list(company25178Level, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "获取公司级别明细")
    @GetMapping("/{companyLevelId}")
    public ResponseEntity<Company25178Level> detail(
            @PathVariable Long companyLevelId) {
        Company25178Level company25178Level = mybatisService.detail(companyLevelId);
        return Results.success(company25178Level);
    }

    @ApiOperation(value = "公司级别批量创建或更新")
    @PostMapping("batchInsertOrUpdate")
    public ResponseEntity<List<Company25178Level>> batchInsertOrUpdate(
            @RequestBody List<Company25178Level> company25178LevelList) {
        Assert.notNull(company25178LevelList, "error.data_invalid");
        for (Company25178Level company25178Level : company25178LevelList) {
            if (company25178Level.getCompanyLevelId() == null) {
                this.validObject(company25178Level, new Class[]{Company25178Level.Insert.class});
            } else {
                this.validObject(company25178Level, new Class[]{Company25178Level.Update.class});
            }
        }
        List<Company25178Level> list = mybatisService.batchInsertOrUpdate(company25178LevelList);
        return Results.success(list);
    }

    @ApiOperation(value = "公司级别批量删除")
    @DeleteMapping("/batchRemove")
    public ResponseEntity<?> batchRemove(
            @RequestBody List<Company25178Level> company25178LevelList) {
        for (Company25178Level company25178Level : company25178LevelList) {
            SecurityTokenHelper.validToken(company25178Level);
        }
        mybatisService.batchRemove(company25178LevelList);
        return Results.success();
    }
}
