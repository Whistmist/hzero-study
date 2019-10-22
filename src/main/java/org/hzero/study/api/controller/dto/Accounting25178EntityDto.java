package org.hzero.study.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.boot.platform.lov.annotation.LovValue;
import org.hzero.mybatis.domian.SecurityToken;
import org.hzero.study.domain.entity.Accounting25178Entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>
 * -- 核算主体 Dto
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-08-21
 */
@ApiModel("核算主体")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Accounting25178EntityDto extends AuditDomain {

    public static final String ACC_ENTITY_ID = "accEntityId";

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
    @Transient
    private String companyTypeCodeMeaning;
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

    @Transient
    private String defaultLanguageMeaning;

    @ApiModelProperty(value = "默认国家")
    @LovValue(lovCode = "HPFM.COUNTRY",meaningField = "defaultCountryIdMeaning")
    private Long defaultCountryId;

    @Transient
    private String defaultCountryIdMeaning;

    @ApiModelProperty(value = "纳税人类型")
    @LovValue(lovCode = "HGLD.TAXPAYER_TYPE",meaningField = "taxpayerTypeCodeMeaning")
    private String taxpayerTypeCode;
    @Transient
    private String taxpayerTypeCodeMeaning;
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
    @ApiModelProperty("币种名称")
    private String currencyName;
    @ApiModelProperty("账套名称")
    private String setOfBooksName;

    //private String _token;

    // setter  getter -------------------

//    @Override
//    public void set_token(String _token) {
//        this._token = _token;
//    }
//    @Override
//    public String get_token() {
//        return this._token;
//    }

    @Override
    public Class<? extends SecurityToken> associateEntityClass() {
        return Accounting25178Entity.class;
    }


    public Long getAccEntityId() {
        return accEntityId;
    }

    public void setAccEntityId(Long accEntityId) {
        this.accEntityId = accEntityId;
    }

    public String getAccEntityCode() {
        return accEntityCode;
    }

    public void setAccEntityCode(String accEntityCode) {
        this.accEntityCode = accEntityCode;
    }

    public String getAccEntityName() {
        return accEntityName;
    }

    public void setAccEntityName(String accEntityName) {
        this.accEntityName = accEntityName;
    }

    public String getFunctionalCurrencyCode() {
        return functionalCurrencyCode;
    }

    public void setFunctionalCurrencyCode(String functionalCurrencyCode) {
        this.functionalCurrencyCode = functionalCurrencyCode;
    }

    public String getPayCurrencyCode() {
        return payCurrencyCode;
    }

    public void setPayCurrencyCode(String payCurrencyCode) {
        this.payCurrencyCode = payCurrencyCode;
    }

    public String getCompanyTypeCode() {
        return companyTypeCode;
    }

    public void setCompanyTypeCode(String companyTypeCode) {
        this.companyTypeCode = companyTypeCode;
    }

    public String getCompanyTypeCodeMeaning() {
        return companyTypeCodeMeaning;
    }

    public void setCompanyTypeCodeMeaning(String companyTypeCodeMeaning) {
        this.companyTypeCodeMeaning = companyTypeCodeMeaning;
    }

    public Date getStartDateActive() {
        return startDateActive;
    }

    public void setStartDateActive(Date startDateActive) {
        this.startDateActive = startDateActive;
    }

    public Date getEndDateActive() {
        return endDateActive;
    }

    public void setEndDateActive(Date endDateActive) {
        this.endDateActive = endDateActive;
    }

    public Long getDefaultSetOfBookId() {
        return defaultSetOfBookId;
    }

    public void setDefaultSetOfBookId(Long defaultSetOfBookId) {
        this.defaultSetOfBookId = defaultSetOfBookId;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getDefaultLanguageMeaning() {
        return defaultLanguageMeaning;
    }

    public void setDefaultLanguageMeaning(String defaultLanguageMeaning) {
        this.defaultLanguageMeaning = defaultLanguageMeaning;
    }

    public Long getDefaultCountryId() {
        return defaultCountryId;
    }

    public void setDefaultCountryId(Long defaultCountryId) {
        this.defaultCountryId = defaultCountryId;
    }

    public String getDefaultCountryIdMeaning() {
        return defaultCountryIdMeaning;
    }

    public void setDefaultCountryIdMeaning(String defaultCountryIdMeaning) {
        this.defaultCountryIdMeaning = defaultCountryIdMeaning;
    }

    public String getTaxpayerTypeCode() {
        return taxpayerTypeCode;
    }

    public void setTaxpayerTypeCode(String taxpayerTypeCode) {
        this.taxpayerTypeCode = taxpayerTypeCode;
    }

    public String getTaxpayerTypeCodeMeaning() {
        return taxpayerTypeCodeMeaning;
    }

    public void setTaxpayerTypeCodeMeaning(String taxpayerTypeCodeMeaning) {
        this.taxpayerTypeCodeMeaning = taxpayerTypeCodeMeaning;
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getSetOfBooksName() {
        return setOfBooksName;
    }

    public void setSetOfBooksName(String setOfBooksName) {
        this.setOfBooksName = setOfBooksName;
    }

}
