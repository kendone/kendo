package com.kendo.security.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class PrincipalRole implements Serializable {

    private static final long serialVersionUID = 6862943771080432517L;
    private String id;//role id
    private String name;// role name

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
