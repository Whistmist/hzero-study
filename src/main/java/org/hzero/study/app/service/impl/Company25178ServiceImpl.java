package org.hzero.study.app.service.impl;

import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.hzero.study.app.service.Company25178Service;
import org.hzero.study.domain.entity.Company25178;
import org.hzero.study.domain.repository.Company25178Repository;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
/**
 * 公司应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-10-15 09:48:25
 */
@Service
public class Company25178ServiceImpl implements Company25178Service {
    @Autowired
    private Company25178Repository company25178Repository;

    /**
     * 获取公司分页列表
     *
     * @param company25178 公司信息
     * @param pageRequest 分页信息
     * @return Page<Company25178>
     */
    @Override
    public Page<Company25178> list(Company25178 company25178, PageRequest pageRequest) {
        Page<Company25178> list = company25178Repository.pageAndSort(pageRequest, company25178);
        return list;
    }

    /**
     * 获取公司明细
     *
     * @param companyId 公司主键Id
     * @return Company25178
     */
    @Override
    public Company25178 detail(Long companyId) {
        Company25178 company25178 = company25178Repository.selectByPrimaryKey(companyId);
        return company25178;
    }

    /**
     * 公司批量创建或更新
     *
     * @param company25178List 公司信息集合
     * @return List<Company25178>
     */
    @Override
	@Transactional(rollbackFor = {Exception.class})
    public List<Company25178> batchInsertOrUpdate(List<Company25178> company25178List){
        if (CollectionUtils.isEmpty(company25178List)) {
            return company25178List;
        } else {
            for (Company25178 company25178 : company25178List) {
                this.insertOrUpdate(company25178);
            }
        }
        return company25178List;
    }

    /**
     * 公司创建或更新
     *
     * @param company25178 公司信息
     * @return Company25178
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Company25178 insertOrUpdate(Company25178 company25178) {
        if (company25178 == null) {
            return null;
        } else {
            if (company25178.getCompanyId() == null) {
                    company25178Repository.insertSelective(company25178);
            } else {
                Company25178 company25178Db = company25178Repository.selectByPrimaryKey(company25178);
                Assert.notNull(company25178Db, "error.data_not_exists");
                                    Assert.isTrue(Objects.equals(company25178Db.getTenantId(), company25178.getTenantId()), "error.data_invalid");
                                    company25178Repository.updateByPrimaryKey(company25178);
            }
            return company25178;
        }
    }

    /**
     * 公司删除
     *
     * @param company25178 公司信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Company25178 company25178) {
            company25178Repository.deleteByPrimaryKey(company25178);
    }

    /**
     * 公司批量删除
     *
     * @param  company25178List 公司信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Company25178> company25178List) {
            company25178Repository.batchDeleteByPrimaryKey(company25178List);

    }

    /**
     * 公司信息 导出接口
     *
     * @param pageRequest
     * @param company25178
     * @return
     */
    @Override
    public Page<Company25178> export(PageRequest pageRequest, Company25178 company25178) {
        return company25178Repository.export(pageRequest, company25178);
    }
}
