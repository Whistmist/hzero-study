package org.hzero.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.study.domain.entity.Company25178Level;

import java.util.List;

/**
 * <p>
 * -- Mybatis增强组件
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-09-10
 */
public interface MybatisService {

    //-------------------   Mybatis增强组件 测试用例  start  -------------------

    /**
     * 获取公司级别分页列表
     *
     * @param company25178Level 公司级别信息
     * @param pageRequest 分页信息
     * @return Page<Company25178Level>
     */
    Page<Company25178Level> select(Company25178Level company25178Level, PageRequest pageRequest);

    /**
     * 根据Condition条件进行查询获取公司级别分页列表
     *
     * @param company25178Level 公司级别信息
     * @param pageRequest 分页信息
     * @return Page<Company25178Level>
     */
    Page<Company25178Level> selectByCondition(Company25178Level company25178Level, PageRequest pageRequest);

    /**
     * 使用 selectOptional 进行查询
     *
     * @param company25178Level 公司级别信息
     * @param pageRequest 分页信息
     * @return Page<Company25178Level>
     */
    Page<Company25178Level> selectOptional(Company25178Level company25178Level, PageRequest pageRequest);



    //-------------------   Mybatis增强组件 测试用例   end   -------------------

    /**
     * 获取公司级别分页列表
     *
     * @param company25178Level 公司级别信息
     * @param pageRequest 分页信息
     * @return Page<Company25178Level>
     */
    Page<Company25178Level> list(Company25178Level company25178Level, PageRequest pageRequest);

    /**
     * 获取公司级别明细
     *
     * @param companyLevelId 公司级别主键Id
     * @return Company25178Level
     */
    Company25178Level detail(Long companyLevelId);

    /**
     * 公司级别创建或更新
     *
     * @param company25178Level 公司级别信息
     * @return Company25178Level
     *
     */
    Company25178Level insertOrUpdate(Company25178Level company25178Level);

    /**
     * 公司级别批量创建或更新
     *
     * @param company25178LevelList 公司级别信息集合
     * @return List<Company25178Level>
     */
    List<Company25178Level> batchInsertOrUpdate(List<Company25178Level> company25178LevelList);

    /**
     * 公司级别删除
     *
     * @param company25178Level 公司级别信息
     * @return
     */
    void remove(Company25178Level company25178Level);

    /**
     * 公司级别批量删除
     *
     * @param  company25178LevelList 公司级别信息集合
     * @return
     */
    void batchRemove(List<Company25178Level>  company25178LevelList);

}
