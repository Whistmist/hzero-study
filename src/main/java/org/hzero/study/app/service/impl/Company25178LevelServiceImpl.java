package org.hzero.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.study.api.controller.dto.Company25178LevelDto;
import org.hzero.study.app.service.Company25178LevelService;
import org.hzero.study.domain.entity.Company25178Level;
import org.hzero.study.domain.repository.Company25178LevelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
/**
 * 公司级别应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-08-15 16:31:34
 */
@Service
public class Company25178LevelServiceImpl implements Company25178LevelService {

    private final Company25178LevelRepository company25178LevelRepository;
    public Company25178LevelServiceImpl(Company25178LevelRepository company25178LevelRepository){
        this.company25178LevelRepository = company25178LevelRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Company25178Level> updateCompanyLevelById(List<Company25178Level> lists) {
        for (Company25178Level company25178Level:lists) {
            Company25178Level exist = company25178LevelRepository.selectByPrimaryKey(company25178Level.getCompanyLevelId());
            if(exist == null){
                throw new CommonException("htdo.warn.companyLevel.notFound");
            }
            company25178Level.setObjectVersionNumber(exist.getObjectVersionNumber());
            company25178LevelRepository.updateByPrimaryKey(company25178Level);
        }
        return lists;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Company25178Level> insertCompanyLevels(List<Company25178Level> company25178LevelLists) {
        return company25178LevelRepository.batchInsertSelective(company25178LevelLists);
    }

    @Override
    public List<Company25178Level> deleteCompanyLevels(List<Company25178Level> company25178LevelLists) {
        company25178LevelRepository.batchDeleteByPrimaryKey(company25178LevelLists);
        return company25178LevelLists;
    }

    /**
     * @param company25178Level
     * @Author: heng.huang@hand-china.com
     * @Description 公司等级信息创建或更新
     * @CreateDate: 2019/8/16
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Company25178Level insertOrUpdate(Company25178Level company25178Level) {
        if(company25178Level == null){
            return null;
        }else {
            //新增
            if(company25178Level.getCompanyLevelId() == null){
                Company25178Level temp = new Company25178Level();
                temp.setCompanyLevelCode(company25178Level.getCompanyLevelCode());
                //通过 CompanyLevelCode 查询数据表记录是否已存在
                if(company25178LevelRepository.selectCount(temp)>0){
                    throw new CommonException("error.code_repeat");
                }
                company25178LevelRepository.insertSelective(company25178Level);
            }else {
                Company25178Level temp = company25178LevelRepository.selectByPrimaryKey(company25178Level);
                Assert.notNull(temp, "error.data_exists");
                Assert.isTrue(Objects.equals(temp.getTenantId(),company25178Level.getTenantId()),"error.data_invalid");
                company25178Level.setObjectVersionNumber(temp.getObjectVersionNumber());
                company25178LevelRepository.updateOptional(company25178Level,
                        Company25178Level.FIELD_COMPANY_LEVEL_CODE,
                        Company25178Level.FIELD_DESCRIPTION,
                        Company25178Level.FIELD_ENABLED_FLAG
                        );
            }
            return company25178Level;
        }
    }

    /**
     * @param lists
     * @Author: heng.huang@hand-china.com
     * @Description 公司等级信息 批量 创建或更新
     * @CreateDate: 2019/8/16
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public List<Company25178Level> batchInsertOrUpdate(List<Company25178Level> lists) {
        if(CollectionUtils.isEmpty(lists)){
            return lists;
        }else {
            for (Company25178Level company25178Level:lists) {
               this.insertOrUpdate(company25178Level);
            }
        }
        return lists;
    }
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  获取公司级别分页列表
     * @CreateDate:  2019/8/20
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Page<Company25178Level> pagepageCompanyLevelList(Company25178Level company25178Level, PageRequest pageRequest) {
        Page<Company25178Level> company25178Levels = company25178LevelRepository.pageAndSort(pageRequest, company25178Level);
        return company25178Levels;
    }

    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  公司级别信息导出
     * @CreateDate:  2019/10/18
     */
    @Override
    public Page<Company25178Level> export(Company25178Level company25178Level, PageRequest pageRequest) {
        return company25178LevelRepository.export(company25178Level,pageRequest);
    }

}
