package com.kendo.admin;

/**
 * @author kendone
 */
public interface BaseService<T> {

    T get(Long id);

    T add(T entity);

    boolean update(T entity);

    void delete(T entity);
}
