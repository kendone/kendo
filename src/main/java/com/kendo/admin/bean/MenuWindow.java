package com.kendo.admin.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class MenuWindow extends AbstractMenu implements Serializable {
    private static final long serialVersionUID = -7931927877381354570L;

    // window properties of the menu for opening the specified window
    private Long id_;
    private String name_;
    private String icon_;
    private String model_;
    private String url_;

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
