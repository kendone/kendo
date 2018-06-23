package com.kendo.api.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class Dept implements Serializable {

    private static final long serialVersionUID = -3958213879129833029L;
    private Long id;//部门id
    private String name;//部门名称

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
