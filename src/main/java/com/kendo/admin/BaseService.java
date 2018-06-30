package com.kendo.admin;

/**
 * @author kendone
 */
public interface BaseService<T> {

    T get(final Long id);

    T add(final T entity);

    boolean update(final T entity);

    void delete(final T entity);
}
