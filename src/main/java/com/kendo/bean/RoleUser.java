package com.kendo.bean;

import java.io.Serializable;

/**
 * @author nason
 */
public class RoleUser implements Serializable {

    private static final long serialVersionUID = -114783697844635848L;

    private Role role;
    private User user;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}