package org.hzero.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.study.api.controller.dto.Period25178Dto;
import org.hzero.study.domain.entity.Period25178;

import java.util.List;
import java.util.Map;

/**
 * 期间应用服务
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
public interface Period25178Service {

    /**
     * 获取期间分页列表
     *
     * @param period25178 期间信息
     * @param pageRequest 分页信息
     * @return Page<Period25178>
     */
    Page<Period25178> list(Period25178 period25178, PageRequest pageRequest);

    /**
     * 获取期间明细
     *
     * @param periodId 期间主键Id
     * @return Period25178
     */
    Period25178 detail(Long periodId);

    /**
     * 期间创建或更新
     *
     * @param period25178 期间信息
     * @return Period25178
     *
     */
    Period25178 insertOrUpdate(Period25178 period25178);

    /**
     * 期间创建
     *
     * @param period25178Dto 期间信息
     * @return Period25178
     */
    List<Period25178> insert(Period25178Dto period25178Dto);

    /**
     * 期间删除
     *
     * @param period25178 期间信息
     * @return
     */
    void remove(Period25178 period25178);

    /**
     * 期间批量删除
     *
     * @param  period25178List 期间信息集合
     * @return
     */
    void batchRemove(List<Period25178> period25178List);

    /**
     * 期间创建 修改
     *
     * @param map 期间信息
     * @return Period25178
     */
    List<Period25178> insertPeriod(Map map);
}
