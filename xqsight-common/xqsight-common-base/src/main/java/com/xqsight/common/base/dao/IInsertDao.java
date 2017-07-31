package com.xqsight.common.base.dao;

import com.xqsight.common.model.BaseModel;

import java.util.List;

/**
 * @author wangganggang
 *
 * @Date 2017/3/23
 */
public interface IInsertDao<T extends BaseModel> {

    /**
     * insert one record ignore id
     *
     * @param record
     * @return update count
     */
    int insert(final T record);

    /**
     * batch insert record
     *
     * @param records
     * @return update count
     */
    int batchInsert(final List<T> records);
}
