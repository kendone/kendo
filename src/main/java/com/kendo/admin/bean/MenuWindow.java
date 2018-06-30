package com.kendo.admin.bean;

import java.io.Serializable;

public class MenuWindow extends AbstractMenu implements Serializable {

    private static final long serialVersionUID = -7931927877381354570L;

    //叶子菜单对应的窗口属性,不是叶子节点该属性为空
    private Long id_;
    private String name_;//窗口名称
    private String icon_;//窗口图标
    private String model_;//系统模块
    private String url_;//打开窗口的url

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getId_() {
        return id_;
    }

    public void setId_(Long id_) {
        this.id_ = id_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getIcon_() {
        return icon_;
    }

    public void setIcon_(String icon_) {
        this.icon_ = icon_;
    }

    public String getModel_() {
        return model_;
    }

    public void setModel_(String model_) {
        this.model_ = model_;
    }

    public String getUrl_() {
        return url_;
    }

    public void setUrl_(String url_) {
        this.url_ = url_;
    }
}
