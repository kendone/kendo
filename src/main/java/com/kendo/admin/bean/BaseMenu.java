package com.kendo.admin.bean;

/**
 * @author kendone
 */
public abstract class BaseMenu {

    protected Long id;//菜单主键ID
    protected String name;//菜单名称
    protected String icon;//菜单图标
    protected Long parentId;//对应父级菜单ID
    protected Integer sort;//排序
}
