package org.hzero.study.app.service;

import java.util.List;

import org.hzero.study.domain.entity.Company25178;
import org.hzero.study.domain.entity.Header;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * 应用服务
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
public interface HeaderService {

    /**
     * 获取分页列表
     *
     * @param header 信息
     * @param pageRequest 分页信息
     * @return Page<Header>
     */
    Page<Header> list(Header header, PageRequest pageRequest);

    /**
     * 获取明细
     *
     * @param id 主键Id
     * @return Header
     */
    Header detail(Long id);

    /**
     * 创建或更新
     *
     * @param header 信息
     * @return Header
     *
     */
    Header insertOrUpdate(Header header);

    /**
     * 批量创建或更新
     *
     * @param headerList 信息集合
     * @return List<Header>
     */
    List<Header> batchInsertOrUpdate(List<Header> headerList);

    /**
     * 删除
     *
     * @param header 信息
     * @return
     */
    void remove(Header header);

    /**
     * 批量删除
     *
     * @param  headerList 信息集合
     * @return
     */
    void batchRemove(List<Header> headerList);

    /**
     * 信息导出
     * @param pageRequest
     * @param header
     * @return
     */
    Page<Header> export(PageRequest pageRequest, Header header);

    /**
     * selectByCondition测试用例（获取分页列表）
     * @param header
     * @param pageRequest
     * @return
     */
    Page<Header> getHeaderDetails(Header header, PageRequest pageRequest);
}
