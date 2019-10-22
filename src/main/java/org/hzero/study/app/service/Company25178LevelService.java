package org.hzero.study.app.service;

import java.util.List;

import org.hzero.study.api.controller.dto.Company25178LevelDto;
import org.hzero.study.domain.entity.Company25178Level;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * 公司级别应用服务
 *
 * @author heng.huang@hand-china.com 2019-08-15 16:31:34
 */
public interface Company25178LevelService {

    /**
     * 更新公司级别信息
     * @param companyLevel
     * @return
     */
    List<Company25178Level> updateCompanyLevelById(List<Company25178Level> companyLevel);
    /**
     * 插入公司级别信息
     * @param companyLevels
     * @return
     */
    public List<Company25178Level> insertCompanyLevels(List<Company25178Level> companyLevels);

    /**
     * 批量删除公司级别信息
     * @param companyLevels
     * @return
     */
    List<Company25178Level> deleteCompanyLevels(List<Company25178Level> companyLevels);
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  公司等级信息创建或更新
     * @CreateDate:  2019/8/16
     */
    Company25178Level insertOrUpdate(Company25178Level company25178Level);
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  公司等级信息 批量 创建或更新
     * @CreateDate:  2019/8/16
     */
    List<Company25178Level> batchInsertOrUpdate(List<Company25178Level> lists);
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  获取公司级别分页列表
     * @CreateDate:  2019/8/20
     */
    Page<Company25178Level> pagepageCompanyLevelList(Company25178Level company25178Level, PageRequest pageRequest);

   /**
    * @Author:  heng.huang@hand-china.com
    * @Description  公司级别信息导出
    * @CreateDate:  2019/10/18
    */
    Page<Company25178Level> export(Company25178Level company25178Level, PageRequest pageRequest);
}
