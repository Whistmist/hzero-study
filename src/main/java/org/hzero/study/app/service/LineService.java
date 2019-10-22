package org.hzero.study.app.service;

import java.util.List;

import org.hzero.study.domain.entity.Line;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * 应用服务
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
public interface LineService {

    /**
     * 获取分页列表
     *
     * @param line 信息
     * @param pageRequest 分页信息
     * @return Page<Line>
     */
    Page<Line> list(Line line, PageRequest pageRequest);

    /**
     * 获取明细
     *
     * @param lineId 主键Id
     * @return Line
     */
    Line detail(Long lineId);

    /**
     * 创建或更新
     *
     * @param line 信息
     * @return Line
     *
     */
    Line insertOrUpdate(Line line);

    /**
     * 批量创建或更新
     *
     * @param lineList 信息集合
     * @return List<Line>
     */
    List<Line> batchInsertOrUpdate(List<Line> lineList);

    /**
     * 删除
     *
     * @param line 信息
     * @return
     */
    void remove(Line line);

    /**
     * 批量删除
     *
     * @param  lineList 信息集合
     * @return
     */
    void batchRemove(List<Line> lineList);
}
