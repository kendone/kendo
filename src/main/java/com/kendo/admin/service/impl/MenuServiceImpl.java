package com.kendo.admin.service.impl;

import com.kendo.admin.bean.Menu;
import com.kendo.admin.bean.MenuWindow;
import com.kendo.admin.bean.MenuWindows;
import com.kendo.admin.mapper.MenuWindowMapper;
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
    private MenuWindowMapper menuWindowMapper;

    @Override
    public List<Menu> findMenuByUsername(String username) {
        return menuMapper.selectMenuByUsername(username);
    }

    @Override
    public MenuWindows findMenuWindowsByMenuId(Map<String, Object> parameters) {
        Long menuId = (Long) parameters.get("menuId");
        List<MenuWindow> menuWindowList = menuWindowMapper.selectMenuWindowByMenuId(parameters);
        MenuWindows menuWindows = new MenuWindows();

        menuWindowList.forEach(menuItem -> {
            if (menuId.equals(menuItem.getId())) {
                menuWindows.setId(menuItem.getId());
                menuWindows.setName(menuItem.getName());
                menuWindows.setIcon(menuItem.getIcon());
                menuWindows.setParentId(menuItem.getParentId());
                menuWindows.setSort(menuItem.getSort());
                menuWindows.setId_(menuItem.getId_());
                menuWindows.setName_(menuItem.getName_());
                menuWindows.setIcon_(menuItem.getIcon_());
                menuWindows.setModel_(menuItem.getModel_());
                menuWindows.setUrl_(menuItem.getUrl_());
            }
        });

        List<MenuWindows> items = toMenuWindows(menuWindowList, menuId);
        menuWindows.setItems(items);

        return menuWindows;
    }

    private static List<MenuWindows> toMenuWindows(List<MenuWindow> menuWindowList, Long parentId) {
        List<MenuWindows> menuWindows = new ArrayList<>();

        for (MenuWindow menuItem : menuWindowList) {
            if (parentId.equals(menuItem.getParentId())) {
                MenuWindows items = new MenuWindows();
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
                items.setItems(toMenuWindows(menuWindowList, menuItem.getId()));
                menuWindows.add(items);
            }
        }

        return menuWindows.size() > 0 ? menuWindows : null;
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
}
