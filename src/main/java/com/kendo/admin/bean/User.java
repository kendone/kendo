package com.kendo.admin.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7238188192495618378L;
    private String id;
    private String name;
    private String username;//name(id)

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
