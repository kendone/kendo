package com.kendo.api.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class Post implements Serializable {

    private static final long serialVersionUID = -6596640114910743414L;
    private Long id;
    private String name;

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
}
