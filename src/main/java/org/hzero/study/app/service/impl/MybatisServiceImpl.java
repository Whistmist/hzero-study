package org.hzero.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.mybatis.common.Criteria;
import org.hzero.mybatis.common.query.Comparison;
import org.hzero.mybatis.common.query.WhereField;
import org.hzero.study.app.service.MybatisService;
import org.hzero.study.domain.entity.Company25178Level;
import org.hzero.study.domain.repository.Company25178LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * -- Mybatis增强组件
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-09-10
 */
@Service
public class MybatisServiceImpl implements MybatisService {

    @Autowired
    private Company25178LevelRepository company25178LevelRepository;

    //-------------------   Mybatis增强组件 测试用例  start  -------------------

    /**
     * 获取公司级别分页列表
     *
     * @param company25178Level 公司级别信息
     * @param pageRequest       分页信息
     * @return Page<Company25178Level>
     */
    @Override
    public Page<Company25178Level> select(Company25178Level company25178Level, PageRequest pageRequest) {
        return PageHelper.doPageAndSort(pageRequest, () -> {
            return company25178LevelRepository.select(company25178Level);
        });
    }

    /**
     * 根据Condition条件进行查询获取公司级别分页列表
     *
     * @param company25178Level 公司级别信息
     * @param pageRequest       分页信息
     * @return Page<Company25178Level>
     */
    @Override
    public Page<Company25178Level> selectByCondition(Company25178Level company25178Level, PageRequest pageRequest) {
        return PageHelper.doPageAndSort(pageRequest, () -> {
            return company25178LevelRepository.selectByCondition(
                org.hzero.mybatis.domian.Condition.builder(Company25178Level.class)
                    .andWhere(
                        org.hzero.mybatis.util.Sqls.custom()
                            .andEqualTo(Company25178Level.FIELD_COMPANY_LEVEL_CODE, company25178Level.getCompanyLevelCode())
                            .andLike(Company25178Level.FIELD_DESCRIPTION, company25178Level.getDescription())
                    ).build()
                );
        });
    }

    /**
     * 使用 selectOptional 进行查询
     *
     * @param company25178Level 公司级别信息
     * @param pageRequest       分页信息
     * @return Page<Company25178Level>
     */
    @Override
    public Page<Company25178Level> selectOptional(Company25178Level company25178Level, PageRequest pageRequest) {
        Criteria criteria = new Criteria();
        criteria.where(
                new WhereField(Company25178Level.FIELD_COMPANY_LEVEL_CODE, Comparison.LIKE),
                Company25178Level.FIELD_COMPANY_LEVEL_ID
        );
        return PageHelper.doPageAndSort(pageRequest, () -> {
            return company25178LevelRepository.selectOptional(company25178Level,criteria);
        });
    }


    //-------------------   Mybatis增强组件 测试用例   end   -------------------

    /**
     * 获取公司级别分页列表
     *
     * @param company25178Level 公司级别信息
     * @param pageRequest 分页信息
     * @return Page<Company25178Level>
     */
    @Override
    public Page<Company25178Level> list(Company25178Level company25178Level, PageRequest pageRequest) {
        Page<Company25178Level> list = company25178LevelRepository.pageAndSort(pageRequest, company25178Level);
        return list;
    }

    /**
     * 获取公司级别明细
     *
     * @param companyLevelId 公司级别主键Id
     * @return Company25178Level
     */
    @Override
    public Company25178Level detail(Long companyLevelId) {
        Company25178Level company25178Level = company25178LevelRepository.selectByPrimaryKey(companyLevelId);
        return company25178Level;
    }

    /**
     * 公司级别批量创建或更新
     *
     * @param company25178LevelList 公司级别信息集合
     * @return List<Company25178Level>
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public List<Company25178Level> batchInsertOrUpdate(List<Company25178Level> company25178LevelList){
        if (CollectionUtils.isEmpty(company25178LevelList)) {
            return company25178LevelList;
        } else {
            for (Company25178Level company25178Level : company25178LevelList) {
                this.insertOrUpdate(company25178Level);
            }
        }
        return company25178LevelList;
    }

    /**
     * 公司级别创建或更新
     *
     * @param company25178Level 公司级别信息
     * @return Company25178Level
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Company25178Level insertOrUpdate(Company25178Level company25178Level) {
        if (company25178Level == null) {
            return null;
        } else {
            if (company25178Level.getCompanyLevelId() == null) {
                company25178LevelRepository.insertSelective(company25178Level);
            } else {
                Company25178Level company25178LevelDb = company25178LevelRepository.selectByPrimaryKey(company25178Level);
                Assert.notNull(company25178LevelDb, "error.data_not_exists");
                Assert.isTrue(Objects.equals(company25178LevelDb.getTenantId(), company25178Level.getTenantId()), "error.data_invalid");
                company25178LevelRepository.updateByPrimaryKey(company25178Level);
            }
            return company25178Level;
        }
    }

    /**
     * 公司级别删除
     *
     * @param company25178Level 公司级别信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(Company25178Level company25178Level) {
        company25178LevelRepository.deleteByPrimaryKey(company25178Level);
    }

    /**
     * 公司级别批量删除
     *
     * @param  company25178LevelList 公司级别信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<Company25178Level> company25178LevelList) {
        company25178LevelRepository.batchDeleteByPrimaryKey(company25178LevelList);

    }
}

