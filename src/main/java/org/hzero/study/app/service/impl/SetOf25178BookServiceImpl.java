package org.hzero.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.study.app.service.SetOf25178BookService;
import org.hzero.study.domain.entity.SetOf25178Book;
import org.hzero.study.domain.repository.SetOf25178BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
/**
 * 账套应用服务默认实现
 *
 * @author heng.huang@hand-china.com 2019-08-21 10:14:16
 */
@Service
public class SetOf25178BookServiceImpl implements SetOf25178BookService {
    @Autowired
    private SetOf25178BookRepository setOf25178BookRepository;

    /**
     * 获取账套分页列表
     *
     * @param setOf25178Book 账套信息
     * @param pageRequest 分页信息
     * @return Page<SetOf25178Book>
     */
    @Override
    public Page<SetOf25178Book> list(SetOf25178Book setOf25178Book, PageRequest pageRequest) {
        Page<SetOf25178Book> list = setOf25178BookRepository.pageAndSort(pageRequest, setOf25178Book);
        return list;
    }

    /**
     * 获取账套明细
     *
     * @param setOfBooksId 账套主键Id
     * @return SetOf25178Book
     */
    @Override
    public SetOf25178Book detail(Long setOfBooksId) {
        SetOf25178Book setOf25178Book = setOf25178BookRepository.selectByPrimaryKey(setOfBooksId);
        return setOf25178Book;
    }

    /**
     * 账套批量创建或更新
     *
     * @param setOf25178BookList 账套信息集合
     * @return List<SetOf25178Book>
     */
    @Override
	@Transactional(rollbackFor = {Exception.class})
    public List<SetOf25178Book> batchInsertOrUpdate(List<SetOf25178Book> setOf25178BookList){
        if (CollectionUtils.isEmpty(setOf25178BookList)) {
            return setOf25178BookList;
        } else {
            for (SetOf25178Book setOf25178Book : setOf25178BookList) {
                this.insertOrUpdate(setOf25178Book);
            }
        }
        return setOf25178BookList;
    }

    /**
     * 账套创建或更新
     *
     * @param setOf25178Book 账套信息
     * @return SetOf25178Book
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public SetOf25178Book insertOrUpdate(SetOf25178Book setOf25178Book) {
        if (setOf25178Book == null) {
            return null;
        } else {
            if (setOf25178Book.getSetOfBooksId() == null) {
                    setOf25178BookRepository.insertSelective(setOf25178Book);
            } else {
                SetOf25178Book setOf25178BookDb = setOf25178BookRepository.selectByPrimaryKey(setOf25178Book);
                Assert.notNull(setOf25178BookDb, "error.data_not_exists");
                setOf25178Book.setObjectVersionNumber(setOf25178BookDb.getObjectVersionNumber());
                setOf25178BookRepository.updateByPrimaryKey(setOf25178Book);
            }
            return setOf25178Book;
        }
    }

    /**
     * 账套删除
     *
     * @param setOf25178Book 账套信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void remove(SetOf25178Book setOf25178Book) {
            setOf25178BookRepository.deleteByPrimaryKey(setOf25178Book);
    }

    /**
     * 账套批量删除
     *
     * @param  setOf25178BookList 账套信息集合
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchRemove(List<SetOf25178Book> setOf25178BookList) {
            setOf25178BookRepository.batchDeleteByPrimaryKey(setOf25178BookList);

    }
}
