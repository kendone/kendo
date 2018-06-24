package com.kendo.admin.service.impl;

import com.kendo.admin.bean.Menu;
import com.kendo.admin.bean.MenuItem;
import com.kendo.admin.bean.MenuItems;
import com.kendo.admin.mapper.MenuItemMapper;
import com.kendo.admin.mapper.MenuMapper;
import com.kendo.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kendone
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuItemMapper menuItemMapper;

       @Override
    public List<Menu> findMenuByUsername(String username) {
        return menuMapper.selectMenuByUsername(username);
    }

    @Override
    public MenuItems findMenuItemsByMenuId(Map<String, Object> parameters) {
        Long menuId = (Long) parameters.get("menuId");
        List<MenuItem> menuItemList = menuItemMapper.selectMenuItemByMenuId(parameters);
        MenuItems menuItems = new MenuItems();
        menuItemList.forEach(menuItem -> {
            if (menuId.equals(menuItem.getId())) {
                menuItems.setId(menuItem.getId());
                menuItems.setName(menuItem.getName());
                menuItems.setIcon(menuItem.getIcon());
                menuItems.setParentId(menuItem.getParentId());
                menuItems.setSort(menuItem.getSort());
                menuItems.setId_(menuItem.getId_());
                menuItems.setName_(menuItem.getName_());
                menuItems.setIcon_(menuItem.getIcon_());
                menuItems.setModel_(menuItem.getModel_());
                menuItems.setUrl_(menuItem.getUrl_());
            }
        });
        List<MenuItems> items = makeMenuItems(menuItemList, menuId);
        menuItems.setItems(items);

        return menuItems;
    }

    @Override
    public HashMap<String, Object> findAll() {
        HashMap<String, Object> dataMap = new HashMap<>();
        List<Menu> items = menuMapper.selectAll();
        dataMap.put("items", items);
        return dataMap;
    }

    @Override
    public Menu get(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Menu entity) {
        menuMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public Menu add(Menu entity) {
        menuMapper.insertIgnoreNull(entity);
        return entity;
    }

    @Override
    public boolean update(Menu entity) {
        return menuMapper.update(entity) > 0;
    }

    private static List<MenuItems> makeMenuItems(List<MenuItem> menuItemList, Long parentId) {
        List<MenuItems> menuItems = new ArrayList<>();

        for (MenuItem menuItem : menuItemList) {
            if (parentId.equals(menuItem.getParentId())) {
                MenuItems items = new MenuItems();
                items.setId(menuItem.getId());
                items.setName(menuItem.getName());
                items.setIcon(menuItem.getIcon());
                items.setParentId(menuItem.getParentId());
                items.setSort(menuItem.getSort());
                items.setId_(menuItem.getId_());
                items.setName_(menuItem.getName_());
                items.setIcon_(menuItem.getIcon_());
                items.setModel_(menuItem.getModel_());
                items.setUrl_(menuItem.getUrl_());
                items.setItems(makeMenuItems(menuItemList, menuItem.getId()));
                menuItems.add(items);
            }
        }

        return menuItems.size() > 0 ? menuItems : null;
    }
}
