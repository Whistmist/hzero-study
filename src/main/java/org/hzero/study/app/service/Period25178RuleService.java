package org.hzero.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.study.domain.entity.Period25178Rule;

import java.util.List;

/**
 * 期间规则应用服务
 *
 * @author heng.huang@hand-china.com 2019-08-26 18:19:07
 */
public interface Period25178RuleService {

    /**
     * 获取期间规则分页列表
     *
     * @param period25178Rule 期间规则信息
     * @param pageRequest 分页信息
     * @return Page<Period25178Rule>
     */
    Page<Period25178Rule> list(Period25178Rule period25178Rule, PageRequest pageRequest);

    /**
     * 获取期间规则明细
     *
     * @param periodRuleId 期间规则主键Id
     * @return Period25178Rule
     */
    Period25178Rule detail(Long periodRuleId);

    /**
     * 期间规则创建或更新
     *
     * @param period25178Rule 期间规则信息
     * @return Period25178Rule
     *
     */
    Period25178Rule insertOrUpdate(Period25178Rule period25178Rule);

    /**
     * 期间规则批量创建或更新
     *
     * @param period25178RuleList 期间规则信息集合
     * @return List<Period25178Rule>
     */
    List<Period25178Rule> batchInsertOrUpdate(List<Period25178Rule> period25178RuleList);

    /**
     * 期间规则删除
     *
     * @param period25178Rule 期间规则信息
     * @return
     */
    void remove(Period25178Rule period25178Rule);

    /**
     * 期间规则批量删除
     *
     * @param  period25178RuleList 期间规则信息集合
     * @return
     */
    void batchRemove(List<Period25178Rule> period25178RuleList);
}
