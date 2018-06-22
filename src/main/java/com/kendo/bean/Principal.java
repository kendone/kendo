package com.kendo.bean;

import java.io.Serializable;

/**
 * 用户身份
 * @author nason
 */
public class Principal implements Serializable {

    private static final long serialVersionUID = -3309242917851705670L;

    private Long id;//用户ID
    private String name;//姓名
    private String username;//账户即工号
    private String identicalName;//姓名(工号)形式的易识别名称
    private String password;//密码
    private String salt;//盐
    private Long deptId;//用户所在部门ID

    public Principal() {
    }

    public Principal(Long id, String username, String name, String identicalName,Long deptId) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.identicalName = identicalName;
        this.deptId = deptId;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
