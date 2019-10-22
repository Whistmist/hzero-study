package org.hzero.study.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;

/**
 * <p>
 * -- 服务路由配置
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-08-14
 */
@ChoerodonExtraData
public class TodoExtra25178DataManager implements ExtraDataManager {

    @Override
    public ExtraData getData() {
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        choerodonRouteData.setName("hord-25178");
        choerodonRouteData.setPath("/hord-25178/**");
        choerodonRouteData.setServiceId("hzero-test-25178");
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}
