package org.hzero.study.api.controller.v1;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.boot.interfaces.sdk.dto.RequestPayloadDTO;
import org.hzero.boot.interfaces.sdk.dto.ResponsePayloadDTO;
import org.hzero.boot.interfaces.sdk.invoke.InterfaceInvokeSdk;
import org.hzero.core.util.Results;
import org.hzero.study.config.SwaggerApi25178Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * -- weather接口
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-09-09
 */
@Api(tags = SwaggerApi25178Config.SDK)
@RestController("Sdk25178Controller.v1")
@RequestMapping("/v1/{organizationId}/sdk-25178")
public class Sdk25178Controller {
    @Autowired
    private InterfaceInvokeSdk interfaceInvokeSdk;

    @ApiOperation(value = "获取天气接口")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("get")
    public ResponseEntity<ResponsePayloadDTO> getResponsePayloadDTO(
            @ApiParam(value = "租户ID", required = true) @PathVariable("organizationId") Long tenantId
    ){
        String interfaceCode = "WEATHER";
        String serverCode = "INTERFACE-25178TEST";
        RequestPayloadDTO payload = new RequestPayloadDTO();
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("cityid","101110101");
        headerMap.put("version","v1");
        headerMap.put("appid","42668377");
        headerMap.put("appsecret","lW4NEVjv");
        payload.setHeaderParamMap(headerMap);
        System.out.println("responsePayloadDTO1---->"+payload);
        ResponsePayloadDTO responsePayloadDTO = interfaceInvokeSdk.invoke(tenantId,
                serverCode,
                interfaceCode,
                payload);
        System.out.println("responsePayloadDTO---->"+responsePayloadDTO);
        return Results.success();
    }
}
