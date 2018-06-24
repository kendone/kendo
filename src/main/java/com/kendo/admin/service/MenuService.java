package com.kendo.admin.service;

import com.kendo.admin.BaseService;
import com.kendo.admin.bean.Menu;
import com.kendo.admin.bean.MenuItems;

import java.util.List;
import java.util.Map;

/**
 * @author kendone
 */
public interface MenuService extends BaseService<Menu> {

    //根据用户查询拥有的叶子菜单
    List<String> findLeafMenuPermissionsByUserId(Long userId);
    //根据用户查询主页面侧边顶级菜单
    List<Menu> findAsideMenusByUserId(Long userId);

    MenuItems findMenuItemsByMenuId(Map<String, Object> parameters);

    Map<String, Object> findAll();
}
