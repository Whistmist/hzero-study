package org.hzero.study.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;

import io.choerodon.mybatis.domain.AuditDomain;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;
import org.hzero.mybatis.common.query.JoinOn;
import org.hzero.mybatis.common.query.JoinTable;
import org.hzero.mybatis.common.query.JoinColumn;
import org.hzero.mybatis.common.query.Where;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "order_header")
@ExcelSheet(zh = "头信息", en = "Header record")
public class Header extends AuditDomain {

    public static final String FIELD_ID = "id";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_NAME = "name";
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

//
// 业务方法(按public protected private顺序排列)
// ------------------------------------------------------------------------------

//
// 数据库字段
// ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @JoinTable(name = "Heasdsdder", target = Line.class, on = @JoinOn(joinField = Line.FIELD_HEADER_ID))
    @Id
    @GeneratedValue
    @ExcelColumn(title = "编号")
    private Long id;

    @ApiModelProperty(value = "价格")
    @ExcelColumn(title = "价格")
    private Long price;

    @Where
    @ApiModelProperty(value = "名称")
    @ExcelColumn(title = "名称")
    private String name;



    //------- start ---------------------------------------------------

    @JoinColumn(joinName = "Heasdsdder", field = Line.FIELD_UNIT_PRICE)
    @ApiModelProperty(value = "单价")
    @Transient
    private Long unitPrice;

    @JoinColumn(joinName = "Heasdsdder", field = Line.FIELD_LINE_NAME)
    @ApiModelProperty(value = "行名称")
    @Transient
    private String lineName;

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }


    //------- end ---------------------------------------------------



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


//
// 非数据库字段
// ------------------------------------------------------------------------------

//    @Transient
//    @ExcelColumn(zh = "行信息", en = "Line", child = true)
//    private List<Line> lineList = new ArrayList<Line>();
//
//    public List<Line> getLineList() {
//        return lineList;
//    }
//
//    public void setLineList(List<Line> lineList) {
//        this.lineList = lineList;
//    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
