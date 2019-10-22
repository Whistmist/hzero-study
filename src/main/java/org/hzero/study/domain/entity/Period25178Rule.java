package org.hzero.study.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 期间规则
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
@ApiModel("期间规则")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "gld_period_25178_rule")
public class Period25178Rule extends AuditDomain {

    public static final String FIELD_PERIOD_RULE_ID = "periodRuleId";
    public static final String FIELD_PERIOD_SET_ID = "periodSetId";
    public static final String FIELD_PERIOD_ADDITIONAL_NAME = "periodAdditionalName";
    public static final String FIELD_PERIOD_NUM = "periodNum";
    public static final String FIELD_MONTH_FROM = "monthFrom";
    public static final String FIELD_MONTH_TO = "monthTo";
    public static final String FIELD_DATE_FROM = "dateFrom";
    public static final String FIELD_DATE_TO = "dateTo";
    public static final String FIELD_QUARTER_NUM = "quarterNum";
    public static final String FIELD_ADJUSTMENT_FLAG = "adjustmentFlag";
    public static final String FIELD_TENANT_ID = "tenantId";

    @ApiModelProperty("主键")
    @Id
    @GeneratedValue
    private Long periodRuleId;

    @ApiModelProperty(value = "会计期ID")
    private Long periodSetId;

    @ApiModelProperty(value = "期间名称附加")
    private String periodAdditionalName;

    @ApiModelProperty(value = "月份")
    private Long periodNum;

    @ApiModelProperty(value = "月份从")
    private Long monthFrom;

    @ApiModelProperty(value = "月份到")
    private Long monthTo;

    @ApiModelProperty(value = "日期从")
    private Long dateFrom;

    @ApiModelProperty(value = "日期到")
    private Long dateTo;

    @ApiModelProperty(value = "季度")
    private Long quarterNum;

    @ApiModelProperty(value = "调整标志")
    private Integer adjustmentFlag;

    @ApiModelProperty(value = "租户")
    @NotNull
    private Long tenantId;

//  setter  getter ------------------------------------------------------------------------------

    /**
     * @return 主键
     */
    public Long getPeriodRuleId() {
        return periodRuleId;
    }

    public void setPeriodRuleId(Long periodRuleId) {
        this.periodRuleId = periodRuleId;
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
     * @return 期间名称附加
     */
    public String getPeriodAdditionalName() {
        return periodAdditionalName;
    }

    public void setPeriodAdditionalName(String periodAdditionalName) {
        this.periodAdditionalName = periodAdditionalName;
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
     * @return 月份从
     */
    public Long getMonthFrom() {
        return monthFrom;
    }

    public void setMonthFrom(Long monthFrom) {
        this.monthFrom = monthFrom;
    }

    /**
     * @return 月份到
     */
    public Long getMonthTo() {
        return monthTo;
    }

    public void setMonthTo(Long monthTo) {
        this.monthTo = monthTo;
    }

    /**
     * @return 日期从
     */
    public Long getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Long dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * @return 日期到
     */
    public Long getDateTo() {
        return dateTo;
    }

    public void setDateTo(Long dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * @return 季度
     */
    public Long getQuarterNum() {
        return quarterNum;
    }

    public void setQuarterNum(Long quarterNum) {
        this.quarterNum = quarterNum;
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
     * @return 租户
     */
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public interface Update {
    }

    public interface Insert {
    }
}
