/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : kendo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-16 16:08:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_button
-- ----------------------------
DROP TABLE IF EXISTS `sys_button`;
CREATE TABLE `sys_button` (
  `ID` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `TEXT` varchar(50) DEFAULT NULL COMMENT '文本',
  `ICON` varchar(50) DEFAULT NULL COMMENT '图标',
  `WINDOW_ID` int(32) NOT NULL COMMENT '窗口ID',
  `EVENT` varchar(100) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL COMMENT '排序号',
  `IS_VALID` tinyint(2) DEFAULT NULL,
  `IS_SHOW` tinyint(2) DEFAULT NULL,
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  KEY `MENU_ID` (`WINDOW_ID`),
  CONSTRAINT `FK_WINDOW_ID` FOREIGN KEY (`WINDOW_ID`) REFERENCES `sys_window` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `ID` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CODE` varchar(100) DEFAULT NULL COMMENT '部门标识符',
  `NAME` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `PARENT_ID` int(32) DEFAULT NULL COMMENT '上级部门ID',
  `MANAGER_ID` int(32) DEFAULT NULL COMMENT '部门领导',
  `LEADER_ID` int(32) DEFAULT NULL COMMENT '部门分管领导',
  `SORT` int(11) DEFAULT NULL COMMENT '部门排序号',
  `IS_VALID` tinyint(1) NOT NULL COMMENT '是否启用:1,启用;0,停用',
  `EXPANDED` varchar(10) DEFAULT '' COMMENT '菜单状态:true展开null/false不展开',
  `IS_LEAF` tinyint(1) NOT NULL COMMENT '叶子节点1是0不是',
  `ICON` varchar(50) DEFAULT NULL COMMENT '图标',
  `CREATE_ID` int(11) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_DEPT_CODE` (`CODE`) USING BTREE,
  KEY `IDX_DEPT_KEYS` (`ID`,`PARENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `ID` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `VALUE` int(11) NOT NULL COMMENT '数据值',
  `TEXT` varchar(100) NOT NULL COMMENT '标签名',
  `TYPE` varchar(100) NOT NULL COMMENT '类型',
  `INFO` varchar(100) NOT NULL COMMENT '描述',
  `SORT` int(3) DEFAULT NULL COMMENT '排序',
  `IS_VALID` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `CREATE_ID` varchar(64) NOT NULL COMMENT '创建人(账号)',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_ID` varchar(64) DEFAULT NULL COMMENT '修改人(账号)',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_VALUE_TYPE` (`VALUE`,`TYPE`) USING BTREE,
  KEY `IDX_TYPE_ISVALID` (`TYPE`,`IS_VALID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Table structure for sys_icon
-- ----------------------------
DROP TABLE IF EXISTS `sys_icon`;
CREATE TABLE `sys_icon` (
  `ID` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '图标名称',
  `ICON` varchar(100) DEFAULT NULL COMMENT '图标值',
  `TYPE` varchar(25) DEFAULT NULL COMMENT '类型',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_ICON_NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=1223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `ID` varchar(64) NOT NULL COMMENT '编号',
  `TYPE` char(1) DEFAULT '1' COMMENT '日志类型',
  `TITLE` varchar(255) DEFAULT '' COMMENT '日志标题',
  `CREATE_ID` int(32) DEFAULT NULL COMMENT '创建者',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `exception` text COMMENT '异常信息',
  PRIMARY KEY (`ID`),
  KEY `sys_log_create_by` (`CREATE_ID`),
  KEY `sys_log_request_uri` (`request_uri`(191)),
  KEY `sys_log_type` (`TYPE`),
  KEY `sys_log_create_date` (`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `NAME` varchar(50) NOT NULL COMMENT '菜单名称',
  `LABEL` varchar(100) DEFAULT NULL COMMENT '菜单提示',
  `PARENT_ID` int(32) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `PERMISSION` varchar(255) DEFAULT NULL COMMENT '权限',
  `ICON` varchar(50) DEFAULT NULL COMMENT '属性节点对应的css样式名称',
  `EXPANDED` varchar(10) DEFAULT '' COMMENT '菜单状态:true展开null/false不展开',
  `IS_LEAF` tinyint(1) DEFAULT NULL COMMENT '叶子节点1是0不是',
  `WINDOW_ID` int(32) DEFAULT NULL COMMENT '打开窗口ID',
  `IS_VALID` tinyint(2) DEFAULT NULL COMMENT '菜单状态1有效0无效',
  `IS_SHOW` tinyint(2) DEFAULT NULL COMMENT '是否显示1显示0隐藏',
  `CREATE_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `SCALE` int(5) DEFAULT NULL COMMENT '层级',
  PRIMARY KEY (`ID`),
  KEY `FK_97mhopbfiw9qkg9qe5fc9cx5t` (`PARENT_ID`),
  KEY `WINDOW_ID` (`WINDOW_ID`),
  CONSTRAINT `sys_menu_ibfk_1` FOREIGN KEY (`PARENT_ID`) REFERENCES `sys_menu` (`ID`),
  CONSTRAINT `sys_menu_ibfk_2` FOREIGN KEY (`WINDOW_ID`) REFERENCES `sys_window` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `ID` int(32) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL COMMENT '岗位名称',
  `TYPE` int(11) DEFAULT NULL COMMENT '岗位类型',
  `CATEGORY` int(11) DEFAULT NULL COMMENT '岗位类别',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `IS_VALID` int(11) DEFAULT NULL COMMENT '是否有效1有效0无效',
  `INFO` varchar(200) DEFAULT NULL COMMENT '岗位描述',
  `CREATE_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `REMARK` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8 COMMENT='岗位表';

-- ----------------------------
-- Table structure for sys_rank
-- ----------------------------
DROP TABLE IF EXISTS `sys_rank`;
CREATE TABLE `sys_rank` (
  `ID` int(32) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL COMMENT '职务级别名称',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `IS_VALID` tinyint(1) DEFAULT NULL COMMENT '状态:1启用2停用',
  `INFO` varchar(255) DEFAULT NULL COMMENT '描述',
  `CREATE_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='职务级别表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CODE` varchar(100) NOT NULL COMMENT '角色代码',
  `NAME` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `TYPE` tinyint(2) DEFAULT NULL COMMENT '角色类型',
  `SORT` int(11) DEFAULT NULL COMMENT '排序号',
  `INFO` varchar(250) DEFAULT NULL COMMENT '角色描述',
  `IS_DEFAULT` tinyint(1) DEFAULT NULL COMMENT '是否默认角色1是0否',
  `IS_VALID` tinyint(1) DEFAULT NULL COMMENT '状态1启用0停用',
  `CREATE_ID` int(11) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_ROLE_CODE` (`CODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_role_button
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_button`;
CREATE TABLE `sys_role_button` (
  `ROLE_ID` int(32) NOT NULL,
  `BUTTON_ID` int(32) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`BUTTON_ID`),
  UNIQUE KEY `UNQ_RB_ID` (`ROLE_ID`,`BUTTON_ID`) USING BTREE,
  KEY `IDX_RB_BUTTON_ID` (`BUTTON_ID`) USING BTREE,
  CONSTRAINT `FK_RB_BUTTON_ID` FOREIGN KEY (`BUTTON_ID`) REFERENCES `sys_button` (`ID`),
  CONSTRAINT `FK_RB_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色按钮表';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `ROLE_ID` int(32) NOT NULL,
  `MENU_ID` int(32) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`MENU_ID`),
  UNIQUE KEY `UNQ_RM_ID` (`ROLE_ID`,`MENU_ID`) USING BTREE,
  KEY `IDX_MENU_ID` (`MENU_ID`) USING BTREE,
  CONSTRAINT `FK_RM_MENU_ID` FOREIGN KEY (`MENU_ID`) REFERENCES `sys_menu` (`ID`),
  CONSTRAINT `FK_RM_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `USER_ID` int(32) NOT NULL,
  `ROLE_ID` int(32) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  UNIQUE KEY `UQ_RU_ID` (`USER_ID`,`ROLE_ID`) USING BTREE,
  KEY `FK_RU_ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `FK_RU_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`),
  CONSTRAINT `FK_RU_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色用户表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id,人员id',
  `USERNAME` varchar(64) NOT NULL COMMENT '账号',
  `NAME` varchar(100) DEFAULT NULL COMMENT '姓名',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '密码',
  `SALT` varchar(50) DEFAULT NULL COMMENT '盐',
  `GENDER` tinyint(1) DEFAULT NULL COMMENT '性别:1男2女3保密',
  `DEPT_ID` int(32) DEFAULT NULL COMMENT '所属部门',
  `POST_ID` int(32) DEFAULT NULL COMMENT '岗位',
  `RANK_ID` int(32) DEFAULT NULL COMMENT '职务级别',
  `PHONE` varchar(50) DEFAULT NULL COMMENT '办公电话',
  `MOBILE` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮件地址',
  `IS_STATUS` tinyint(1) DEFAULT NULL COMMENT '人员状态1在职0离职',
  `IS_FORMAL` tinyint(1) DEFAULT NULL COMMENT '人员类型1正式0劳务',
  `IS_VALID` tinyint(1) DEFAULT '1' COMMENT '账户状态1启用0禁用',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最近登录时间',
  `GRANT_ID` int(32) DEFAULT NULL COMMENT '授权用户',
  `GRANT_BEGIN_DATE` datetime DEFAULT NULL COMMENT '授权开始日期',
  `GRANT_END_DATE` datetime DEFAULT NULL COMMENT '授权结束日期',
  `THEME` varchar(200) DEFAULT NULL COMMENT '主题',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `HEAD_IMG_URL` varchar(255) DEFAULT NULL COMMENT '头像url',
  `CREATE_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`) USING BTREE,
  KEY `POST_ID` (`POST_ID`),
  KEY `RANK_ID` (`RANK_ID`),
  KEY `user_ibfk_1` (`DEPT_ID`),
  CONSTRAINT `FK_DEPT_ID` FOREIGN KEY (`DEPT_ID`) REFERENCES `sys_dept` (`ID`) ON UPDATE SET NULL,
  CONSTRAINT `FK_POST_ID` FOREIGN KEY (`POST_ID`) REFERENCES `sys_post` (`ID`),
  CONSTRAINT `FK_RANK_ID` FOREIGN KEY (`RANK_ID`) REFERENCES `sys_rank` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for sys_window
-- ----------------------------
DROP TABLE IF EXISTS `sys_window`;
CREATE TABLE `sys_window` (
  `ID` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `NAME` varchar(50) DEFAULT NULL COMMENT '窗口名称',
  `PARENT_ID` int(32) DEFAULT '1',
  `ICON` varchar(20) DEFAULT NULL COMMENT '窗口图标',
  `MODEL` varchar(100) DEFAULT NULL COMMENT '窗口所属模块',
  `URL` varchar(100) DEFAULT NULL COMMENT 'URL路径',
  `IS_VALID` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `IS_SHOW` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可见',
  `IS_LEAF` tinyint(1) NOT NULL DEFAULT '1' COMMENT '叶子节点1是0不是',
  `EXPANDED` varchar(10) DEFAULT '' COMMENT '菜单状态:true展开null/false不展开',
  `CREATE_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  KEY `PARENT_ID` (`PARENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
