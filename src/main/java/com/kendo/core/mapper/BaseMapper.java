package com.kendo.core.mapper;

/**
 * @author kendone
 */
public interface BaseMapper<T> {

    /**
     * 通过主键获取实体
     *
     * @param id 主键id
     * @return T
     */
    T selectByPrimaryKey(Long id);

    /**
     * 新增
     *
     * @param entity T
     * @return 受影响的行数(获取主键通过T.getId方法进行获取)
     */
    int insert(T entity);

    /**
     * 新增 - 忽略值为空的列
     *
     * @param entity T
     * @return 受影响的行数(获取主键通过T.getId方法进行获取)
     */
    int insertIgnoreNull(T entity);

    /**
     * 修改
     *
     * @param entity T
     * @return 受影响的行数
     */
    int update(T entity);

    /**
     * 修改 - 忽略值为空的列
     *
     * @param entity T
     * @return 受影响的行数
     */
    int updateIgnoreNull(T entity);

    /**
     * 删除
     *
     * @param id 主键
     * @return the affected row for deleted
     */
    int deleteByPrimaryKey(Long id);
}
