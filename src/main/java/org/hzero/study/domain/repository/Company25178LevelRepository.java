package org.hzero.study.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.study.api.controller.dto.Company25178LevelDto;
import org.hzero.study.domain.entity.Company25178Level;

/**
 * 公司级别资源库
 *
 * @author heng.huang@hand-china.com 2019-08-15 16:31:34
 */
public interface Company25178LevelRepository extends BaseRepository<Company25178Level> {
    /**
     * 根据 公司级别代码、描述信息 模糊查询公司等级信息
     * @param companyLevelDto
     * @return
     */
    Page<Company25178Level> queryLevelByCodeAndDescription(Company25178LevelDto companyLevelDto, PageRequest pageRequest);
    /**
     * @Author:  heng.huang@hand-china.com
     * @Description  公司级别信息导出
     * @CreateDate:  2019/10/18
     */
    Page<Company25178Level> export(Company25178Level company25178Level, PageRequest pageRequest);
}
