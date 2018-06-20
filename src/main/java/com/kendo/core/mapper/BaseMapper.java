package com.kendo.core.mapper;

/**
 * @author kendone
 */
public interface BaseMapper<T> {

    T selectByPrimaryKey(Long id);

    int insert(T entity);

    int insertIgnoreNull(T entity);

    int update(T entity);

    int updateIgnoreNull(T entity);

    int deleteByPrimaryKey(Long id);

}
