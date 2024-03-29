package org.hzero.study.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.MultiLanguage;
import io.choerodon.mybatis.annotation.MultiLanguageField;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 账套
 *
 * @author heng.huang@hand-china.com 2019-08-21 10:14:16
 */
@ApiModel("账套")
@VersionAudit
@ModifyAudit
@MultiLanguage
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "gld_set_of_25178_book")
public class SetOf25178Book extends AuditDomain {

    public static final String FIELD_SET_OF_BOOKS_ID = "setOfBooksId";
    public static final String FIELD_SET_OF_BOOKS_NAME = "setOfBooksName";
    public static final String FIELD_SET_OF_BOOKS_CODE = "setOfBooksCode";
    public static final String FIELD_PERIOD_SET_ID = "periodSetId";
    public static final String FIELD_FUNCTIONAL_CURRENCY_CODE = "functionalCurrencyCode";
    public static final String FIELD_ACCOUNT_SET_ID = "accountSetId";
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


    @ApiModelProperty("主键")
    @Id
    @GeneratedValue
    private Long setOfBooksId;

    @ApiModelProperty(value = "账套名称")
    @NotBlank
    @MultiLanguageField
    private String setOfBooksName;

    @ApiModelProperty(value = "账套代码")
    @NotBlank
    private String setOfBooksCode;

    @ApiModelProperty(value = "期间集ID")
    @NotNull
    private Long periodSetId;

    @ApiModelProperty(value = "币种代码")
    @NotBlank
    private String functionalCurrencyCode;

    @ApiModelProperty(value = "科目集ID")
    @NotNull
    private Long accountSetId;

    @ApiModelProperty(value = "启用")
    @NotNull
    private Integer enabledFlag;

    @ApiModelProperty(value = "租户")
    @NotNull
    private Long tenantId;

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



// getter setter  ------------------------------------------------------------------------------

    /**
     * @return 主键
     */
    public Long getSetOfBooksId() {
        return setOfBooksId;
    }

    public void setSetOfBooksId(Long setOfBooksId) {
        this.setOfBooksId = setOfBooksId;
    }

    /**
     * @return 账套名称
     */
    public String getSetOfBooksName() {
        return setOfBooksName;
    }

    public void setSetOfBooksName(String setOfBooksName) {
        this.setOfBooksName = setOfBooksName;
    }

    /**
     * @return 账套代码
     */
    public String getSetOfBooksCode() {
        return setOfBooksCode;
    }

    public void setSetOfBooksCode(String setOfBooksCode) {
        this.setOfBooksCode = setOfBooksCode;
    }

    /**
     * @return 期间集ID
     */
    public Long getPeriodSetId() {
        return periodSetId;
    }

    public void setPeriodSetId(Long periodSetId) {
        this.periodSetId = periodSetId;
    }

    /**
     * @return 币种代码
     */
    public String getFunctionalCurrencyCode() {
        return functionalCurrencyCode;
    }

    public void setFunctionalCurrencyCode(String functionalCurrencyCode) {
        this.functionalCurrencyCode = functionalCurrencyCode;
    }

    /**
     * @return 科目集ID
     */
    public Long getAccountSetId() {
        return accountSetId;
    }

    public void setAccountSetId(Long accountSetId) {
        this.accountSetId = accountSetId;
    }

    /**
     * @return 启用
     */
    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
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
