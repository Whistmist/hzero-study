package org.hzero.study.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 期间
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@ApiModel("期间")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "gld_period_25178")
public class Period25178 extends AuditDomain {

    public static final String FIELD_PERIOD_ID = "periodId";
    public static final String FIELD_PERIOD_SET_ID = "periodSetId";
    public static final String FIELD_PERIOD_YEAR = "periodYear";
    public static final String FIELD_PERIOD_NUM = "periodNum";
    public static final String FIELD_PERIOD_NAME = "periodName";
    public static final String FIELD_ADJUSTMENT_FLAG = "adjustmentFlag";
    public static final String FIELD_INTERNAL_PERIOD_NUM = "internalPeriodNum";
    public static final String FIELD_START_DATE = "startDate";
    public static final String FIELD_END_DATE = "endDate";
    public static final String FIELD_QUARTER_NUM = "quarterNum";
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

    @ApiModelProperty("期间ID")
    @Id
    @GeneratedValue
    private Long periodId;

    @ApiModelProperty(value = "会计期ID")
    private Long periodSetId;

    @ApiModelProperty(value = "年")
    private Long periodYear;

    @ApiModelProperty(value = "月份")
    private Long periodNum;

    @ApiModelProperty(value = "期间名称")
    private String periodName;

    @ApiModelProperty(value = "调整标志")
    private Integer adjustmentFlag;

    @ApiModelProperty(value = "期间序号")
    private Long internalPeriodNum;

    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @ApiModelProperty(value = "日期从")
    private Date startDate;

    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @ApiModelProperty(value = "日期到")
    private Date endDate;

    @ApiModelProperty(value = "度")
    private Long quarterNum;

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
     * @return 期间ID
     */
    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    /**
     * @return 会计期ID
     */
    public Long getPeriodSetId() {
        return periodSetId;
    }

    public void setPeriodSetId(Long periodSetId) {
        this.periodSetId = periodSetId;
    }

    /**
     * @return 年
     */
    public Long getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(Long periodYear) {
        this.periodYear = periodYear;
    }

    /**
     * @return 月份
     */
    public Long getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(Long periodNum) {
        this.periodNum = periodNum;
    }

    /**
     * @return 期间名称
     */
    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    /**
     * @return 调整标志
     */
    public Integer getAdjustmentFlag() {
        return adjustmentFlag;
    }

    public void setAdjustmentFlag(Integer adjustmentFlag) {
        this.adjustmentFlag = adjustmentFlag;
    }

    /**
     * @return 期间序号
     */
    public Long getInternalPeriodNum() {
        return internalPeriodNum;
    }

    public void setInternalPeriodNum(Long internalPeriodNum) {
        this.internalPeriodNum = internalPeriodNum;
    }

    /**
     * @return 日期从
     */
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return 日期到
     */
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return 度
     */
    public Long getQuarterNum() {
        return quarterNum;
    }

    public void setQuarterNum(Long quarterNum) {
        this.quarterNum = quarterNum;
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
