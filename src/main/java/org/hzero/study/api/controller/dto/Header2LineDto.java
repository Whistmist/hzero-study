package org.hzero.study.api.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hzero.export.annotation.ExcelColumn;
import org.hzero.study.domain.entity.Header;
import org.hzero.study.domain.entity.Line;

/**
 * <p>
 * -- 头行导入
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-10-16
 */
public class Header2LineDto {

    private Long price;
    private String name;

    private Long unitPrice;
    private Long headerId;
    private String lineName;


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
}
