package org.hzero.study.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.boot.platform.lov.annotation.LovValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 核算主体
 *
 * @author heng.huang@hand-china.com 2019-08-20 16:48:13
 */
@ApiModel("核算主体")
@VersionAudit
@ModifyAudit
@io.choerodon.mybatis.annotation.MultiLanguage
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "gld_accounting_25178_entity")
public class Accounting25178Entity extends AuditDomain {

    public static final String FIELD_ACC_ENTITY_ID = "accEntityId";
    public static final String FIELD_ACC_ENTITY_CODE = "accEntityCode";
    public static final String FIELD_ACC_ENTITY_NAME = "accEntityName";
    public static final String FIELD_FUNCTIONAL_CURRENCY_CODE = "functionalCurrencyCode";
    public static final String FIELD_PAY_CURRENCY_CODE = "payCurrencyCode";
    public static final String FIELD_COMPANY_TYPE_CODE = "companyTypeCode";
    public static final String FIELD_START_DATE_ACTIVE = "startDateActive";
    public static final String FIELD_END_DATE_ACTIVE = "endDateActive";
    public static final String FIELD_DEFAULT_SET_OF_BOOK_ID = "defaultSetOfBookId";
    public static final String FIELD_DEFAULT_LANGUAGE = "defaultLanguage";
    public static final String FIELD_DEFAULT_COUNTRY_ID = "defaultCountryId";
    public static final String FIELD_TAXPAYER_TYPE_CODE = "taxpayerTypeCode";
    public static final String FIELD_TAXPAYER_NUMBER = "taxpayerNumber";
    public static final String FIELD_PHONE = "phone";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_BANK_ACCOUNT = "bankAccount";
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
    private Long accEntityId;

    @ApiModelProperty(value = "核算主体代码")
    @NotBlank
    private String accEntityCode;

    @ApiModelProperty(value = "核算主体名称")
    @NotBlank
    @io.choerodon.mybatis.annotation.MultiLanguageField
    private String accEntityName;

    @ApiModelProperty(value = "本位币")
    private String functionalCurrencyCode;

    @ApiModelProperty(value = "支付币种")
    @NotBlank
    private String payCurrencyCode;
    @LovValue(lovCode = "HGLD.COMPANY_TYPE",meaningField = "companyTypeCodeMeaning")
    @ApiModelProperty(value = "公司类型")
    @NotBlank
    private String companyTypeCode;

    @ApiModelProperty(value = "有效期从")
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    private Date startDateActive;

    @ApiModelProperty(value = "有效期至")
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    private Date endDateActive;

    @ApiModelProperty(value = "默认账套")
    private Long defaultSetOfBookId;

    @ApiModelProperty(value = "默认语言")
    @LovValue(lovCode = "HPFM.LANGUAGE2",meaningField = "defaultLanguageMeaning")
    private String defaultLanguage;


    @ApiModelProperty(value = "默认国家")
    @LovValue(lovCode = "HPFM.COUNTRY",meaningField = "defaultCountryIdMeaning")
    private Long defaultCountryId;

    @ApiModelProperty(value = "纳税人类型")
    @LovValue(lovCode = "HGLD.TAXPAYER_TYPE",meaningField = "taxpayerTypeCodeMeaning")
    private String taxpayerTypeCode;

    @ApiModelProperty(value = "纳税人识别号")
    private String taxpayerNumber;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "银行账户")
    private String bankAccount;

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

    @Transient
    private String taxpayerTypeCodeMeaning;
    @Transient
    private String defaultLanguageMeaning;
    @Transient
    private String defaultCountryIdMeaning;
    @Transient
    private String companyTypeCodeMeaning;

// getter setter ------------------------------------------------------------------------------

    /**
     * @return 主键
     */
    public Long getAccEntityId() {
        return accEntityId;
    }

    public void setAccEntityId(Long accEntityId) {
        this.accEntityId = accEntityId;
    }

    /**
     * @return 核算主体代码
     */
    public String getAccEntityCode() {
        return accEntityCode;
    }

    public void setAccEntityCode(String accEntityCode) {
        this.accEntityCode = accEntityCode;
    }

    /**
     * @return 核算主体名称
     */
    public String getAccEntityName() {
        return accEntityName;
    }

    public void setAccEntityName(String accEntityName) {
        this.accEntityName = accEntityName;
    }

    /**
     * @return 本位币
     */
    public String getFunctionalCurrencyCode() {
        return functionalCurrencyCode;
    }

    public void setFunctionalCurrencyCode(String functionalCurrencyCode) {
        this.functionalCurrencyCode = functionalCurrencyCode;
    }

    /**
     * @return 支付币种
     */
    public String getPayCurrencyCode() {
        return payCurrencyCode;
    }

    public void setPayCurrencyCode(String payCurrencyCode) {
        this.payCurrencyCode = payCurrencyCode;
    }

    /**
     * @return 公司类型
     */
    public String getCompanyTypeCode() {
        return companyTypeCode;
    }

    public void setCompanyTypeCode(String companyTypeCode) {
        this.companyTypeCode = companyTypeCode;
    }

    /**
     * @return 有效期从
     */
    public Date getStartDateActive() {
        return startDateActive;
    }

    public void setStartDateActive(Date startDateActive) {
        this.startDateActive = startDateActive;
    }

    /**
     * @return 有效期至
     */
    public Date getEndDateActive() {
        return endDateActive;
    }

    public void setEndDateActive(Date endDateActive) {
        this.endDateActive = endDateActive;
    }

    /**
     * @return 默认账套
     */
    public Long getDefaultSetOfBookId() {
        return defaultSetOfBookId;
    }

    public void setDefaultSetOfBookId(Long defaultSetOfBookId) {
        this.defaultSetOfBookId = defaultSetOfBookId;
    }

    /**
     * @return 默认语言
     */
    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    /**
     * @return 默认国家
     */
    public Long getDefaultCountryId() {
        return defaultCountryId;
    }

    public void setDefaultCountryId(Long defaultCountryId) {
        this.defaultCountryId = defaultCountryId;
    }

    /**
     * @return 纳税人类型
     */
    public String getTaxpayerTypeCode() {
        return taxpayerTypeCode;
    }

    public void setTaxpayerTypeCode(String taxpayerTypeCode) {
        this.taxpayerTypeCode = taxpayerTypeCode;
    }

    /**
     * @return 纳税人识别号
     */
    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    /**
     * @return 电话
     */
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
     * @return 银行账户
     */
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
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

    public String getTaxpayerTypeCodeMeaning() {
        return taxpayerTypeCodeMeaning;
    }

    public void setTaxpayerTypeCodeMeaning(String taxpayerTypeCodeMeaning) {
        this.taxpayerTypeCodeMeaning = taxpayerTypeCodeMeaning;
    }

    public String getDefaultLanguageMeaning() {
        return defaultLanguageMeaning;
    }

    public void setDefaultLanguageMeaning(String defaultLanguageMeaning) {
        this.defaultLanguageMeaning = defaultLanguageMeaning;
    }

    public String getDefaultCountryIdMeaning() {
        return defaultCountryIdMeaning;
    }

    public void setDefaultCountryIdMeaning(String defaultCountryIdMeaning) {
        this.defaultCountryIdMeaning = defaultCountryIdMeaning;
    }

    public String getCompanyTypeCodeMeaning() {
        return companyTypeCodeMeaning;
    }

    public void setCompanyTypeCodeMeaning(String companyTypeCodeMeaning) {
        this.companyTypeCodeMeaning = companyTypeCodeMeaning;
    }

    public interface Update {
    }

    public interface Insert {
    }

}
