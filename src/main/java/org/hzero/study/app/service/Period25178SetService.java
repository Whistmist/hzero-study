package org.hzero.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.study.domain.entity.Period25178Set;

import java.util.List;

/**
 * 会计期应用服务
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
public interface Period25178SetService {

    /**
     * 获取会计期分页列表
     *
     * @param period25178Set 会计期信息
     * @param pageRequest 分页信息
     * @return Page<Period25178Set>
     */
    Page<Period25178Set> list(Period25178Set period25178Set, PageRequest pageRequest);

    /**
     * 获取会计期明细
     *
     * @param periodSetId 会计期主键Id
     * @return Period25178Set
     */
    Period25178Set detail(Long periodSetId);

    /**
     * 会计期创建或更新
     *
     * @param period25178Set 会计期信息
     * @return Period25178Set
     *
     */
    Period25178Set insertOrUpdate(Period25178Set period25178Set);

    /**
     * 会计期批量创建或更新
     *
     * @param period25178SetList 会计期信息集合
     * @return List<Period25178Set>
     */
    List<Period25178Set> batchInsertOrUpdate(List<Period25178Set> period25178SetList);

    /**
     * 会计期删除
     *
     * @param period25178Set 会计期信息
     * @return
     */
    void remove(Period25178Set period25178Set);

    /**
     * 会计期批量删除
     *
     * @param  period25178SetList 会计期信息集合
     * @return
     */
    void batchRemove(List<Period25178Set> period25178SetList);

    /**
     * 根据会计期代码、会计期名称 获取会计期信息
     *
     * @param period25178Set
     * @return
     */
    Page<Period25178Set> queryPeriodSetByCodeAndName(Period25178Set period25178Set,PageRequest pageRequest);
}
