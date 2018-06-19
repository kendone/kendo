package com.kendo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nason
 */
public class Dept implements Serializable {

    private static final long serialVersionUID = -2876243766117026373L;

    private Long id;//主键id
    private String code;//部门唯一标识符
    private String name;//部门名称
    private Dept parentDept;//父级部门对象(parent_id)
    private User managerUser;//部门主管人员对象(manager_id)
    private User leaderUser;//分管领导人员对象(leader_id)
    private Integer sort;//排序
    private Integer isValid;//是否启用1启用0未启用
    private String expanded;//展开状态true展开false/null不展开
    private Integer isLeaf;//叶子节点1是0否
    private String icon;//图标样式
    private User createUser;//创建人人员对象(create_id)
    private Date createTime;//创建时间
    private String remark;//备注

    public Dept() {
    }

    public Dept(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Dept getParentDept() {
        return parentDept;
    }

    public void setParentDept(Dept parentDept) {
        this.parentDept = parentDept;
    }

    public User getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(User managerUser) {
        this.managerUser = managerUser;
    }

    public User getLeaderUser() {
        return leaderUser;
    }

    public void setLeaderUser(User leaderUser) {
        this.leaderUser = leaderUser;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getExpanded() {
        return expanded;
    }

    public void setExpanded(String expanded) {
        this.expanded = expanded == null ? null : expanded.trim();
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}