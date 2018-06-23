package com.kendo.api.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3115833177509155278L;
    private Long id;
    private String name;
    private String username;
    private String identicalName;//name(username)

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdenticalName() {
        return identicalName;
    }

    public void setIdenticalName(String identicalName) {
        this.identicalName = identicalName;
    }
}
