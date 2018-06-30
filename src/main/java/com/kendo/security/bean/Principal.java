package com.kendo.security.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author kendone
 */
public class Principal implements Serializable {

    private static final long serialVersionUID = -3309242917851705670L;

    private String id;
    private String name;
    private String password;
    private List<PrincipalRole> roles;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PrincipalRole> getRoles() {
        return roles;
    }

    public void setRoles(List<PrincipalRole> roles) {
        this.roles = roles;
    }
}
