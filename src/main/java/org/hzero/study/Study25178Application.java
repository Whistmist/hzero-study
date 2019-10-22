package org.hzero.study;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "org.hzero.study.infra.feign")
@EnableDiscoveryClient
@EnableChoerodonResourceServer
@SpringBootApplication
public class Study25178Application {

    public static void main(String[] args) {
        SpringApplication.run(Study25178Application.class, args);
    }

}
