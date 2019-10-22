package org.hzero.study.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.mybatis.domian.SecurityToken;
import org.hzero.study.domain.entity.Period25178Rule;

import java.util.List;

/**
 * <p>
 * -- PeriodDto
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-08-28
 */
@ApiModel("期间")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Period25178Dto extends AuditDomain {

    @ApiModelProperty("年度从")
    private Long yearFrom;
    @ApiModelProperty("年度到")
    private Long yearTo;
    @ApiModelProperty("期间规则")
    private List<Period25178Rule> period25178RuleList;

    @Override
    public Class<? extends SecurityToken> associateEntityClass() {
        return Period25178Rule.class;
    }


    //  setter  getter ------------------------------------------------------------------------------

    public Long getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Long yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Long getYearTo() {
        return yearTo;
    }

    public void setYearTo(Long yearTo) {
        this.yearTo = yearTo;
    }

    public List<Period25178Rule> getPeriod25178RuleList() {
        return period25178RuleList;
    }

    public void setPeriod25178RuleList(List<Period25178Rule> period25178RuleList) {
        this.period25178RuleList = period25178RuleList;
    }
}
