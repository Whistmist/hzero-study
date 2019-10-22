package org.hzero.study.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hzero.mybatis.domian.SecurityToken;
import org.hzero.study.domain.entity.Company25178Level;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * -- 公司级别信息 CompanyLevelDto
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-08-14
 */
@ApiModel("公司级别信息")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company25178LevelDto extends AuditDomain {

    @NotNull
    @ApiModelProperty(value="公司等级编码")
    @Length(max=30)
    private String companyLevelCode;
    @ApiModelProperty(value="描述")
    @Length(max=2000)
    private String description;

    @Override
    public Class<? extends SecurityToken> associateEntityClass() {
        return Company25178Level.class;
    }


    // -------setter  getter----------

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
}
