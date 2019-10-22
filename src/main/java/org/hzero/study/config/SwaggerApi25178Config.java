package org.hzero.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>
 * -- Swagger Api 描述配置
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-08-14
 */
@Configuration
public class SwaggerApi25178Config {
    public static final String COMPANYLEVEL = "CompanyLevel";
    public static final String COMPANY = "Company";
    public static final String ACCOUNTINGENTITY = "AccountingEntity";
    public static final String SETOFBOOK = "SetOfBook";
    public static final String CURRENCY = "Currency";
    public static final String PERIOD = "Period";
    public static final String PERIODSET = "PeriodSet";
    public static final String PERIODRULE = "PeriodRule";
    public static final String COMPANYREMOTE = "CompanyRemote";
    public static final String SDK = "sdk";
    public static final String MYBATIS = "Mybatis";
    public static final String HEADER = "Header";
    public static final String LINE = "Line";
    public static final String CUSTOMER = "Customer";


    @Autowired
    public SwaggerApi25178Config(Docket docket) {
        docket.tags(
                new Tag(COMPANYLEVEL, "公司级别接口"),
                new Tag(COMPANY, "公司信息接口"),
                new Tag(ACCOUNTINGENTITY, "核算主体接口"),
                new Tag(SETOFBOOK, "账套接口"),
                new Tag(CURRENCY, "币种接口"),
                new Tag(PERIOD, "期间接口"),
                new Tag(PERIODSET, "会计期接口"),
                new Tag(PERIODRULE, "期间规则接口"),
                new Tag(COMPANYREMOTE, "company-feign接口"),
                new Tag(SDK, "接口平台客户端"),
                new Tag(MYBATIS, "Mybatis增强组件测试用例"),
                new Tag(HEADER, "Excel 导出"),
                new Tag(LINE, "行信息"),
                new Tag(CUSTOMER, "系统级客户主数据")
        );
    }
}
