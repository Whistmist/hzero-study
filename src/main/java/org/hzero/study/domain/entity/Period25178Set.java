package org.hzero.study.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.MultiLanguage;
import io.choerodon.mybatis.annotation.MultiLanguageField;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.boot.platform.lov.annotation.LovValue;
import org.hzero.mybatis.common.query.Where;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * 会计期
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@ApiModel("会计期")
@MultiLanguage
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "gld_period_25178_set")
public class Period25178Set extends AuditDomain {

    public static final String FIELD_PERIOD_SET_ID = "periodSetId";
    public static final String FIELD_PERIOD_SET_CODE = "periodSetCode";
    public static final String FIELD_PERIOD_SET_NAME = "periodSetName";
    public static final String FIELD_TOTAL_PERIOD_NUM = "totalPeriodNum";
    public static final String FIELD_PERIOD_ADDITIONAL_FLAG = "periodAdditionalFlag";
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
    private Long periodSetId;

    @ApiModelProperty(value = "会计期代码")
    @Where
    private String periodSetCode;

    @ApiModelProperty(value = "会计期名称")
    @MultiLanguageField
    @Where
    private String periodSetName;

    @ApiModelProperty(value = "会计期间总数")
    private Long totalPeriodNum;

    @ApiModelProperty(value = "名称附加")
    @LovValue(lovCode = "HGLD.PERIOD_ADDITIONAL",meaningField = "periodAdditionalFlagMeaning")
    private String periodAdditionalFlag;

    @Transient
    private String periodAdditionalFlagMeaning;

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

//  setter  getter ------------------------------------------------------------------------------

    /**
     * @return 主键
     */
    public Long getPeriodSetId() {
        return periodSetId;
    }

    public void setPeriodSetId(Long periodSetId) {
        this.periodSetId = periodSetId;
    }

    /**
     * @return 会计期代码
     */
    public String getPeriodSetCode() {
        return periodSetCode;
    }

    public void setPeriodSetCode(String periodSetCode) {
        this.periodSetCode = periodSetCode;
    }

    /**
     * @return 会计期名称
     */
    public String getPeriodSetName() {
        return periodSetName;
    }

    public void setPeriodSetName(String periodSetName) {
        this.periodSetName = periodSetName;
    }

    /**
     * @return 会计期间总数
     */
    public Long getTotalPeriodNum() {
        return totalPeriodNum;
    }

    public void setTotalPeriodNum(Long totalPeriodNum) {
        this.totalPeriodNum = totalPeriodNum;
    }

    /**
     * @return 名称附加
     */
    public String getPeriodAdditionalFlag() {
        return periodAdditionalFlag;
    }

    public void setPeriodAdditionalFlag(String periodAdditionalFlag) {
        this.periodAdditionalFlag = periodAdditionalFlag;
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

    public String getPeriodAdditionalFlagMeaning() {
        return periodAdditionalFlagMeaning;
    }

    public void setPeriodAdditionalFlagMeaning(String periodAdditionalFlagMeaning) {
        this.periodAdditionalFlagMeaning = periodAdditionalFlagMeaning;
    }

    public interface Update {
    }

    public interface Insert {
    }
}
