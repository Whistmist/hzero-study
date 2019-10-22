package org.hzero.study.app.service.impl;

import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.hzero.study.app.service.LineService;
import org.hzero.study.domain.entity.Line;
import org.hzero.study.domain.repository.LineRepository;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
/**
 * 应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
@Service
public class LineServiceImpl implements LineService {
    @Autowired
    private LineRepository lineRepository;

    /**
     * 获取分页列表
     *
     * @param line 信息
     * @param pageRequest 分页信息
     * @return Page<Line>
     */
    @Override
    public Page<Line> list(Line line, PageRequest pageRequest) {
        Page<Line> list = lineRepository.pageAndSort(pageRequest, line);
        return list;
    }

    /**
     * 获取明细
     *
     * @param lineId 主键Id
     * @return Line
     */
    @Override
    public Line detail(Long lineId) {
        Line line = lineRepository.selectByPrimaryKey(lineId);
        return line;
    }

    /**
     * 批量创建或更新
     *
     * @param lineList 信息集合
     * @return List<Line>
     */
    @Override
	@Transactional(rollbackFor = {Exception.class})
    public List<Line> batchInsertOrUpdate(List<Line> lineList){
        if (CollectionUtils.isEmpty(lineList)) {
            return lineList;
        } else {
            for (Line line : lineList) {
                this.insertOrUpdate(line);
            }
        }
        return lineList;
    }

    /**
     * 创建或更新
     *
     * @param line 信息
     * @return Line
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Line insertOrUpdate(Line line) {
        if (line == null) {
            return null;
        } else {
            if (line.getLineId() == null) {
                    lineRepository.insertSelective(line);
            } else {
                Line lineDb = lineRepository.selectByPrimaryKey(line);
                Assert.notNull(lineDb, "error.data_not_exists");
                                    lineRepository.updateByPrimaryKey(line);
            }
            return line;
        }
    }

    /**
     * 删除
     *
     * @param line 信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Line line) {
            lineRepository.deleteByPrimaryKey(line);
    }

    /**
     * 批量删除
     *
     * @param  lineList 信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Line> lineList) {
            lineRepository.batchDeleteByPrimaryKey(lineList);

    }
}
