package org.hzero.study.app.service;

import java.util.List;

import org.hzero.study.domain.entity.SetOf25178Book;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * 账套应用服务
 *
 * @author heng.huang@hand-china.com 2019-08-21 10:14:16
 */
public interface SetOf25178BookService {

    /**
     * 获取账套分页列表
     *
     * @param setOf25178Book 账套信息
     * @param pageRequest 分页信息
     * @return Page<SetOf25178Book>
     */
    Page<SetOf25178Book> list(SetOf25178Book setOf25178Book, PageRequest pageRequest);

    /**
     * 获取账套明细
     *
     * @param setOfBooksId 账套主键Id
     * @return SetOf25178Book
     */
    SetOf25178Book detail(Long setOfBooksId);

    /**
     * 账套创建或更新
     *
     * @param setOf25178Book 账套信息
     * @return SetOf25178Book
     *
     */
    SetOf25178Book insertOrUpdate(SetOf25178Book setOf25178Book);

    /**
     * 账套批量创建或更新
     *
     * @param setOf25178BookList 账套信息集合
     * @return List<SetOf25178Book>
     */
    List<SetOf25178Book> batchInsertOrUpdate(List<SetOf25178Book> setOf25178BookList);

    /**
     * 账套删除
     *
     * @param setOf25178Book 账套信息
     * @return
     */
    void remove(SetOf25178Book setOf25178Book);

    /**
     * 账套批量删除
     *
     * @param  setOf25178BookList 账套信息集合
     * @return
     */
    void batchRemove(List<SetOf25178Book> setOf25178BookList);
}
