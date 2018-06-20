package com.kendo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kendone
 */
public class User implements Serializable {

    private static final long serialVersionUID = 6609892533006502730L;

    private Long id;//主键id
    private String username;//用户名(工号)
    private String name;//姓名
    private String password;//密码
    private Integer gender;//性别
    private Dept dept;//部门
    private Post post;//岗位
    private Rank rank;//岗位级别
    private String phone;//办公电话
    private String mobile;//手机号码
    private String email;//邮件地址
    private Integer isStatus;//人员状态1在职0离职
    private Integer isFormal;//人员类型1正式0劳务
    private Integer isValid;//账户状态1启用0禁用
    private Date lastLoginTime;//最近登陆时间
    private User grantUser;//授权用户
    private Date grantBeginDate;//授权开始日期
    private Date grantEndDate;//授权结束日期
    private String theme;//系统主题
    private Long sort;//排序
    private String headImgUrl;//图像url地址
    private User createUser;//创建人
    private Date createTime;//创建日期
    private String remark;//备注

    public User() {
        super();
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public Integer getIsFormal() {
        return isFormal;
    }

    public void setIsFormal(Integer isFormal) {
        this.isFormal = isFormal;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public User getGrantUser() {
        return grantUser;
    }

    public void setGrantUser(User grantUser) {
        this.grantUser = grantUser;
    }

    public Date getGrantBeginDate() {
        return grantBeginDate;
    }

    public void setGrantBeginDate(Date grantBeginDate) {
        this.grantBeginDate = grantBeginDate;
    }

    public Date getGrantEndDate() {
        return grantEndDate;
    }

    public void setGrantEndDate(Date grantEndDate) {
        this.grantEndDate = grantEndDate;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
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
        this.remark = remark;
    }
}