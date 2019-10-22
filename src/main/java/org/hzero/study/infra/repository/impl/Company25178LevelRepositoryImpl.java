package org.hzero.study.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.study.api.controller.dto.Company25178LevelDto;
import org.hzero.study.domain.entity.Company25178Level;
import org.hzero.study.domain.repository.Company25178LevelRepository;
import org.hzero.study.infra.mapper.Company25178LevelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 公司级别 资源库实现
 *
 * @author heng.huang@hand-china.com 2019-08-15 16:31:34
 */
@Component
public class Company25178LevelRepositoryImpl extends BaseRepositoryImpl<Company25178Level> implements Company25178LevelRepository {

    private final Company25178LevelMapper company25178LevelMapper;

    public Company25178LevelRepositoryImpl(Company25178LevelMapper company25178LevelMapper){
        this.company25178LevelMapper = company25178LevelMapper;
    }
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  根据 公司级别代码、描述信息 模糊查询公司等级信息
     * @CreateDate:  2019/8/15
     */
    @Override
    public Page<Company25178Level> queryLevelByCodeAndDescription(Company25178LevelDto company25178LevelDto,PageRequest pageRequest) {
        return PageHelper.doPageAndSort(pageRequest, () -> {
            return company25178LevelMapper.queryCompanyLevelByCodeAndDescription(company25178LevelDto);
        });

    }

    /**
     * @param company25178Level
     * @param pageRequest
     * @Author: heng.huang@hand-china.com
     * @Description 公司级别信息导出
     * @CreateDate: 2019/10/18
     */
    @Override
    public Page<Company25178Level> export(Company25178Level company25178Level, PageRequest pageRequest) {
        return PageHelper.doPageAndSort(pageRequest, () -> company25178LevelMapper.select(company25178Level));
    }
}
