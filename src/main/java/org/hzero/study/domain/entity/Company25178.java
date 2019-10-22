package org.hzero.study.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 公司
 *
 * @author heng.huang@hand-china.com 2019-09-10 11:37:05
 */
@ApiModel("公司")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "fnd_company_25178")
@ExcelSheet(zh = "公司信息表", en = "company record")
public class Company25178 extends AuditDomain {

    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_COMPANY_CODE = "companyCode";
    public static final String FIELD_COMPANY_SHORT_NAME = "companyShortName";
    public static final String FIELD_COMPANY_FULL_NAME = "companyFullName";
    public static final String FIELD_MAG_ORG_ID = "magOrgId";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_COMPANY_LEVEL_ID = "companyLevelId";
    public static final String FIELD_PARENT_COMPANY_ID = "parentCompanyId";
    public static final String FIELD_LANGUAGE = "language";
    public static final String FIELD_MANAGING_CURRENRY_CODE = "managingCurrenryCode";
    public static final String FIELD_CHIEF_POSITION_ID = "chiefPositionId";
    public static final String FIELD_START_DATE_ACTIVE = "startDateActive";
    public static final String FIELD_END_DATE_ACTIVE = "endDateActive";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_ATTRIBUTE_CATEGORY = "attributeCategory";
    public static final String FIELD_ATTRIBUTE1 = "attribute1";
    public static final String FIELD_ATTRIBUTE2 = "attribute2";
    public static final String FIELD_ATTRIBUTE3 = "attribute3";
    public static final String FIELD_ATTRIBUTE4 = "attribute4";
    public static final String FIELD_ATTRIBUTE5 = "attribute5";
    public static final String FIELD_ATTRIBUTE6 = "attribute6";
    public static final String FIELD_ATTRIBUTE7 = "attribute7";
    public static final String FIELD_ATTRIBUTE8 = "attribute8";
    public static final String FIELD_ATTRIBUTE9 = "attribute9";
    public static final String FIELD_ATTRIBUTE10 = "attribute10";
    public static final String FIELD_ATTRIBUTE11 = "attribute11";
    public static final String FIELD_ATTRIBUTE12 = "attribute12";
    public static final String FIELD_ATTRIBUTE13 = "attribute13";
    public static final String FIELD_ATTRIBUTE14 = "attribute14";
    public static final String FIELD_ATTRIBUTE15 = "attribute15";

//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------

//
// 数据库字段
// ------------------------------------------------------------------------------


    @ApiModelProperty("主键")
    @Id
    @GeneratedValue
    private Long companyId;

    @ApiModelProperty(value = "公司代码")
    @NotBlank
    @ExcelColumn(title = "公司代码")
    private String companyCode;

    @ApiModelProperty(value = "公司简称")
    @NotBlank
    @ExcelColumn(title = "公司简称")
    private String companyShortName;

    @ApiModelProperty(value = "公司全称")
    @ExcelColumn(title = "公司全称")
    private String companyFullName;

    @ApiModelProperty(value = "管理组织ID")
    @NotNull
    private Long magOrgId;

    @ApiModelProperty(value = "地址")
    @ExcelColumn(title = "地址")
    private String address;

    @ApiModelProperty(value = "公司级别ID")
    private Long companyLevelId;

    @ApiModelProperty(value = "父级公司ID")
    private Long parentCompanyId;

    @ApiModelProperty(value = "语言")
    private String language;

    @ApiModelProperty(value = "管理币种")
    private String managingCurrenryCode;

    @ApiModelProperty(value = "主岗位")
    private Long chiefPositionId;

    @ApiModelProperty(value = "开始日期")
    @NotNull
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    private Date startDateActive;

    @ApiModelProperty(value = "结束日期")
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    private Date endDateActive;

    @ApiModelProperty(value = "租户")
    @NotNull
    private Long tenantId;

    private String attributeCategory;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    private String attribute7;

    private String attribute8;

    private String attribute9;

    private String attribute10;

    private String attribute11;

    private String attribute12;

    private String attribute13;

    private String attribute14;

    private String attribute15;

// 非数据库字段
// ------------------------------------------------------------------------------

    @Transient
    @ExcelColumn(zh = "公司层级", en = "CompanyLevel",child = true)
    List<Company25178Level> company25178LevelLists = new ArrayList<Company25178Level>();

// getter/setter
// ------------------------------------------------------------------------------


    public List<Company25178Level> getCompany25178Level() {
        return company25178LevelLists;
    }

    public void setCompany25178Level(List<Company25178Level> company25178Level) {
        this.company25178LevelLists = company25178Level;
    }

    /**
     * @return 主键
     */
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return 公司代码
     */
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * @return 公司简称
     */
    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    /**
     * @return 公司全称
     */
    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    /**
     * @return 管理组织ID
     */
    public Long getMagOrgId() {
        return magOrgId;
    }

    public void setMagOrgId(Long magOrgId) {
        this.magOrgId = magOrgId;
    }

    /**
     * @return 地址
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 公司级别ID
     */
    public Long getCompanyLevelId() {
        return companyLevelId;
    }

    public void setCompanyLevelId(Long companyLevelId) {
        this.companyLevelId = companyLevelId;
    }

    /**
     * @return 父级公司ID
     */
    public Long getParentCompanyId() {
        return parentCompanyId;
    }

    public void setParentCompanyId(Long parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
    }

    /**
     * @return 语言
     */
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return 管理币种
     */
    public String getManagingCurrenryCode() {
        return managingCurrenryCode;
    }

    public void setManagingCurrenryCode(String managingCurrenryCode) {
        this.managingCurrenryCode = managingCurrenryCode;
    }

    /**
     * @return 主岗位
     */
    public Long getChiefPositionId() {
        return chiefPositionId;
    }

    public void setChiefPositionId(Long chiefPositionId) {
        this.chiefPositionId = chiefPositionId;
    }

    /**
     * @return 开始日期
     */
    public Date getStartDateActive() {
        return startDateActive;
    }

    public void setStartDateActive(Date startDateActive) {
        this.startDateActive = startDateActive;
    }

    /**
     * @return 结束日期
     */
    public Date getEndDateActive() {
        return endDateActive;
    }

    public void setEndDateActive(Date endDateActive) {
        this.endDateActive = endDateActive;
    }

    /**
     * @return 租户
     */
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }

    public interface Update {
    }

    public interface Insert {
    }
}
