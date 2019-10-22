package org.hzero.study.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.MultiLanguage;
import io.choerodon.mybatis.annotation.MultiLanguageField;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;
import org.hzero.mybatis.common.query.Comparison;
import org.hzero.mybatis.common.query.Where;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 公司级别
 *
 * @author heng.huang@hand-china.com 2019-08-15 16:31:34
 */
@MultiLanguage
@ApiModel("公司级别")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "fnd_company_25178_level")
@ExcelSheet(zh = "公司层级", en = "CompanyLevel")
public class Company25178Level extends AuditDomain{

    public static final String FIELD_COMPANY_LEVEL_ID = "companyLevelId";
    public static final String FIELD_COMPANY_LEVEL_CODE = "companyLevelCode";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
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
    @Id
    @GeneratedValue
    private Long companyLevelId;
    @NotNull
    @ApiModelProperty(value="公司等级编码")
    @Where(comparison = Comparison.LIKE)
    @ExcelColumn(zh="公司等级编码",en = "companyLevelCode")

    private String companyLevelCode;

    @NotNull
    @Where(comparison = Comparison.LIKE)
    @ApiModelProperty(value="描述")
    @MultiLanguageField
    @ExcelColumn(zh="描述",en = "description")
    private String description;
    @NotNull
    @ApiModelProperty(value="启用标识")
    @ExcelColumn(zh="启用标识",en = "enabledFlag")
    private Integer enabledFlag;
    @NotNull
    @ApiModelProperty(value="租户id")
    private Long tenantId;
    @ApiModelProperty(value="",hidden = true)
    private String attributeCategory;
    @ApiModelProperty(value="",hidden = true)
    private String attribute1;
    @ApiModelProperty(value="",hidden = true)
    private String attribute2;
    @ApiModelProperty(value="",hidden = true)
    private String attribute3;
    @ApiModelProperty(value="",hidden = true)
    private String attribute4;
    @ApiModelProperty(value="",hidden = true)
    private String attribute5;
    @ApiModelProperty(value="",hidden = true)
    private String attribute6;
    @ApiModelProperty(value="",hidden = true)
    private String attribute7;
    @ApiModelProperty(value="",hidden = true)
    private String attribute8;
    @ApiModelProperty(value="",hidden = true)
    private String attribute9;
    @ApiModelProperty(value="",hidden = true)
    private String attribute10;
    @ApiModelProperty(value="",hidden = true)
    private String attribute11;
    @ApiModelProperty(value="",hidden = true)
    private String attribute12;
    @ApiModelProperty(value="",hidden = true)
    private String attribute13;
    @ApiModelProperty(value="",hidden = true)
    private String attribute14;
    @ApiModelProperty(value="",hidden = true)
    private String attribute15;




    // -------setter  getter----------

    public Long getCompanyLevelId() {
        return companyLevelId;
    }

    public void setCompanyLevelId(Long companyLevelId) {
        this.companyLevelId = companyLevelId;
    }

    public String getCompanyLevelCode() {
        return companyLevelCode;
    }

    public void setCompanyLevelCode(String companyLevelCode) {
        this.companyLevelCode = companyLevelCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

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
