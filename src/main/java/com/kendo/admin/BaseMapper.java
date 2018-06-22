package com.kendo.admin;

/**
 * @author kendone
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Long id);

    int insertIgnoreNull(T entity);

    int update(T entity);

    T selectByPrimaryKey(Long id);
}
