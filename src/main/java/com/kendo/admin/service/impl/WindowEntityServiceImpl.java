package com.kendo.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kendo.admin.bean.WindowEntity;
import com.kendo.admin.mapper.WindowEntityMapper;
import com.kendo.admin.service.WindowEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author kendone
 */
@Service
public class WindowEntityServiceImpl implements WindowEntityService {

    @Autowired
    private WindowEntityMapper windowEntityMapper;

    @Override
    public List<WindowEntity> findValidWindow() {
        List<WindowEntity> items = windowEntityMapper.selectValidWindow();
        return items != null && items.size() > 0 ? items : Collections.EMPTY_LIST;
    }

    @Override
    public List<WindowEntity> findValidWindowByWindowId(Long id) {
        return windowEntityMapper.selectValidWindowByWindowId(id);
    }

    @Override
    public HashMap<String, Object> find(WindowEntity window, Integer page, Integer pageSize) {
        if (page == null) page = 1;
        if (pageSize == null || pageSize > 20) pageSize = 20;

        PageHelper.startPage(page, pageSize);
        List<WindowEntity> items = windowEntityMapper.find(window);
        PageInfo<WindowEntity> pageInfo = new PageInfo<>(items);
        Long itemCount = pageInfo.getTotal();
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("items", items);
        dataMap.put("itemCount", itemCount);
        return dataMap;
    }

    @Override
    public List<WindowEntity> find(WindowEntity window) {
        return windowEntityMapper.find(window);
    }

    @Override
    public WindowEntity get(Long id) {
        return windowEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> find(Integer page, Integer pageSize) {
        if (page == null) page = 1;
        if (pageSize == null || pageSize > 20) pageSize = 20;

        PageHelper.startPage(page, pageSize);
        List<WindowEntity> items = windowEntityMapper.find(null);
        PageInfo<WindowEntity> pageInfo = new PageInfo<>(items);
        Long itemCount = pageInfo.getTotal();
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("items", items);
        dataMap.put("itemCount", itemCount);
        return dataMap;
    }

    @Transactional
    public WindowEntity add(WindowEntity entity) {
        windowEntityMapper.insertIgnoreNull(entity);
        return entity;
    }

    @Override
    public boolean update(WindowEntity entity) {
        return windowEntityMapper.update(entity) > 0;
    }

    @Override
    public void delete(WindowEntity entity) {
        windowEntityMapper.deleteByPrimaryKey(entity.getId());
    }
}
