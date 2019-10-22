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
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.study.api.controller.dto.Company25178LevelDto;
import org.hzero.study.app.service.Company25178LevelService;
import org.hzero.study.config.SwaggerApi25178Config;
import org.hzero.study.domain.entity.Company25134Level;
import org.hzero.study.domain.entity.Company25178Level;
import org.hzero.study.domain.entity.Header;
import org.hzero.study.domain.repository.Company25178LevelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;



/**
 * 公司级别 管理 API
 *
 * @author heng.huang@hand-china.com 2019-08-15 16:31:34
 */
@Api(tags = SwaggerApi25178Config.COMPANYLEVEL)
@RestController("company25178LevelController.v1")
@RequestMapping("/v1/{organizationId}/company25178-levels")
public class Company25178LevelController extends BaseController {


    private final Company25178LevelRepository company25178LevelRepository;
    private final Company25178LevelService company25178LevelService;

    public Company25178LevelController(Company25178LevelRepository company25178LevelRepository,Company25178LevelService company25178LevelService) {
        this.company25178LevelRepository = company25178LevelRepository;
        this.company25178LevelService = company25178LevelService;
    }


    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  公司等级信息导出
     * @CreateDate:  2019/8/14
     */
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "公司等级信息导出-11")
    @ExcelExport(Company25178Level.class)
    @GetMapping("/export")
    public ResponseEntity<Page<Company25178Level>> companyLevelExport(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            ExportParam exportParam,
            HttpServletResponse httpServletResponse,
            Company25178LevelDto company25178LevelDto,
            @ApiIgnore PageRequest pageRequest) {
        return Results.success(company25178LevelRepository.queryLevelByCodeAndDescription(company25178LevelDto,pageRequest));
    }

    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  根据 公司级别代码、描述信息 模糊查询公司等级信息
     * @CreateDate:  2019/8/14
     */
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "查询公司等级信息")
    @GetMapping("/get")
    public ResponseEntity<Page<Company25178Level>> queryCompanyLevelByCodeAndDescription(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,Company25178LevelDto company25178LevelDto,
            @ApiIgnore @SortDefault(value = Company25178Level.FIELD_COMPANY_LEVEL_ID,direction = Sort.Direction.DESC) PageRequest pageRequest) {
        //数据校验
        //this.validObject(companyLevelDto);
        return Results.success(company25178LevelRepository.queryLevelByCodeAndDescription(company25178LevelDto,pageRequest));
    }
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  更新公司等级信息
     * @CreateDate:  2019/8/14
     */
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "更新公司等级信息")
    @PutMapping("/update")
    public ResponseEntity<List<Company25178Level>>  updateCompanyLevelById(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId, @RequestBody List<Company25178Level> lists){
        //数据校验
        this.validList(lists);
        //数据防篡改 验证 token
        SecurityTokenHelper.validToken(lists);
        return Results.success(company25178LevelService.updateCompanyLevelById(lists));
    }
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  批量插入公司等级信息
     * @CreateDate:  2019/8/15
     */
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "批量插入公司等级信息")
    @PostMapping("/insert")
    public ResponseEntity<List<Company25178Level>>  insertCompanyLevels(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId, @RequestBody List<Company25178Level> lists){
        for (Company25178Level company25178Level : lists) {
            company25178Level.setTenantId(tenantId);
        }
        return Results.success(company25178LevelService.insertCompanyLevels(lists));
    }
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  批量删除公司等级信息
     * @CreateDate:  2019/8/15
     */
    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "批量删除公司等级信息")
    @DeleteMapping("/delete")
    public ResponseEntity<List<Company25178Level>>  deleteCompanyLevels(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId, @RequestBody List<Company25178Level> companyLevels){
        for (Company25178Level companyLevel : companyLevels) {
            SecurityTokenHelper.validToken(companyLevel);
        }
        return Results.success(company25178LevelService.deleteCompanyLevels(companyLevels));
    }

    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  公司等级信息创建或更新
     * @CreateDate:  2019/8/16
     */
    @ApiOperation(value = "公司等级信息创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/insertOrUpdate")
    public ResponseEntity<Company25178Level> insertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody Company25178Level company25178Level){
        this.validObject(company25178Level);
        SecurityTokenHelper.validTokenIgnoreInsert(company25178Level);
        return Results.success(company25178LevelService.insertOrUpdate(company25178Level));
    }
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  公司等级信息 批量 创建或更新
     * @CreateDate:  2019/8/16
     */
    @ApiOperation(value = "公司等级信息 批量 创建或更新")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/batchInsertOrUpdate")
    public ResponseEntity<List<Company25178Level>> batchInsertOrUpdate(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId,
            @RequestBody List<Company25178Level> lists){
        Assert.notNull(lists, "error.data_invalid");
        SecurityTokenHelper.validTokenIgnoreInsert(lists);
        for (Company25178Level company25178Level : lists) {
            company25178Level.setTenantId(tenantId);
            if (company25178Level.getCompanyLevelId() == null) {
                this.validObject(company25178Level, new Class[]{Company25178Level.Insert.class});
            } else {
                this.validObject(company25178Level, new Class[]{Company25178Level.Update.class});
            }
        }
        return Results.success(company25178LevelService.batchInsertOrUpdate(lists));
    }
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  获取公司级别分页列表
     * @CreateDate:  2019/8/20
     */
    @ApiOperation(value = "获取公司级别分页列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/pageCompanyLevel")
    public ResponseEntity<Page<Company25178Level>> pageCompanyLevel(
            @ApiParam(value = "租户ID",required = true) @PathVariable("organizationId") Long tenantId,
            Company25178Level company25178Level,
            @ApiIgnore @SortDefault(value = Company25134Level.FIELD_COMPANY_LEVEL_ID, direction = Sort.Direction.DESC) PageRequest pageRequest
    ){
        Page<Company25178Level> company25178Levels = company25178LevelService.pagepageCompanyLevelList(company25178Level,pageRequest);
        return Results.success(company25178Levels);
    }

}
