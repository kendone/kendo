package com.kendo.security.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class PrincipalRole implements Serializable {

    private Integer id;
    private String roleName;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
