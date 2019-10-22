package org.hzero.study.app.service;

import java.util.List;

import org.hzero.study.domain.entity.Company25178;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * 公司应用服务
 *
 * @author heng.huang@hand-china.com 2019-10-15 09:48:25
 */
public interface Company25178Service {

    /**
     * 获取公司分页列表
     *
     * @param company25178 公司信息
     * @param pageRequest 分页信息
     * @return Page<Company25178>
     */
    Page<Company25178> list(Company25178 company25178, PageRequest pageRequest);

    /**
     * 获取公司明细
     *
     * @param companyId 公司主键Id
     * @return Company25178
     */
    Company25178 detail(Long companyId);

    /**
     * 公司创建或更新
     *
     * @param company25178 公司信息
     * @return Company25178
     *
     */
    Company25178 insertOrUpdate(Company25178 company25178);

    /**
     * 公司批量创建或更新
     *
     * @param company25178List 公司信息集合
     * @return List<Company25178>
     */
    List<Company25178> batchInsertOrUpdate(List<Company25178> company25178List);

    /**
     * 公司删除
     *
     * @param company25178 公司信息
     * @return
     */
    void remove(Company25178 company25178);

    /**
     * 公司批量删除
     *
     * @param  company25178List 公司信息集合
     * @return
     */
    void batchRemove(List<Company25178> company25178List);

    /**
     * 公司信息 导出接口
     * @param pageRequest
     * @param company25178
     * @return
     */
    Page<Company25178> export(PageRequest pageRequest, Company25178 company25178);
}
