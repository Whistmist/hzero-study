package org.hzero.study.app.service.impl;

import java.util.List;
import java.util.Objects;

import io.choerodon.mybatis.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.mybatis.common.Criteria;
import org.hzero.mybatis.common.query.SortType;
import org.hzero.study.app.service.HeaderService;
import org.hzero.study.domain.entity.Company25178;
import org.hzero.study.domain.entity.Header;
import org.hzero.study.domain.repository.HeaderRepository;
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
public class HeaderServiceImpl implements HeaderService {
    @Autowired
    private HeaderRepository headerRepository;

    /**
     * 获取分页列表
     *
     * @param header      信息
     * @param pageRequest 分页信息
     * @return Page<Header>
     */
    @Override
    public Page<Header> list(Header header, PageRequest pageRequest) {
        Page<Header> list = headerRepository.pageAndSort(pageRequest, header);
        return list;
    }

    /**
     * 获取明细
     *
     * @param id 主键Id
     * @return Header
     */
    @Override
    public Header detail(Long id) {
        Header header = headerRepository.selectByPrimaryKey(id);
        return header;
    }

    /**
     * 批量创建或更新
     *
     * @param headerList 信息集合
     * @return List<Header>
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public List<Header> batchInsertOrUpdate(List<Header> headerList) {
        if (CollectionUtils.isEmpty(headerList)) {
            return headerList;
        } else {
            for (Header header : headerList) {
                this.insertOrUpdate(header);
            }
        }
        return headerList;
    }

    /**
     * 创建或更新
     *
     * @param header 信息
     * @return Header
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Header insertOrUpdate(Header header) {
        if (header == null) {
            return null;
        } else {
            if (header.getId() == null) {
                headerRepository.insertSelective(header);
            } else {
                Header headerDb = headerRepository.selectByPrimaryKey(header);
                Assert.notNull(headerDb, "error.data_not_exists");
                headerRepository.updateByPrimaryKey(header);
            }
            return header;
        }
    }

    /**
     * 删除
     *
     * @param header 信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Header header) {
        headerRepository.deleteByPrimaryKey(header);
    }

    /**
     * 批量删除
     *
     * @param headerList 信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Header> headerList) {
        headerRepository.batchDeleteByPrimaryKey(headerList);

    }

    /**
     * 信息导出
     *
     * @param pageRequest
     * @param header
     * @return
     */
    @Override
    public Page<Header> export(PageRequest pageRequest, Header header) {
        return headerRepository.export(pageRequest, header);
    }

    /**
     * selectByCondition测试用例（获取分页列表）
     *
     * @param header
     * @param pageRequest
     * @return
     */
    @Override
    public Page<Header> getHeaderDetails(Header header, PageRequest pageRequest) {
        return PageHelper.doPageAndSort(pageRequest, () -> {

            return headerRepository.selectOptional(
                    header,
                    new Criteria().select("unitPrice","lineName").sort(Header.FIELD_ID, SortType.ASC)
            );
        });
    }
}
