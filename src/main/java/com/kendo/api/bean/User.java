package com.kendo.api.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class User implements Serializable {
    private static final long serialVersionUID = -3115833177509155278L;

    private String id; //USERNAME
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
