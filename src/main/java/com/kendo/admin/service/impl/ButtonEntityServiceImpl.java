package com.kendo.admin.service.impl;

import com.kendo.admin.bean.ButtonEntity;
import com.kendo.admin.mapper.ButtonEntityMapper;
import com.kendo.admin.service.ButtonEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kendone
 */
@Service
public class ButtonEntityServiceImpl implements ButtonEntityService {

    @Autowired
    private ButtonEntityMapper buttonEntityMapper;
    //@Autowired
    //private RoleResourceMapper roleResourceMapper;

    //========================== SELECT ==================

    @Override
    public ButtonEntity get(Long id) {
        return buttonEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> findButtonByWindowId(Long windowId) {
        HashMap<String, Object> dataMap = new HashMap<>();
        //List<ButtonEntity> items = buttonEntityMapper.selectButtonsByWindow(windowId);
        //dataMap.put("items", items);
        return dataMap;
    }

    //========================== INSERT ==================

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public ButtonEntity add(ButtonEntity entity) {
        //新增按钮将按钮授权给超级管理员
        buttonEntityMapper.insertIgnoreNull(entity);
        return entity;
    }

    //========================== UPDATE ==================

    @Override
    public boolean update(ButtonEntity entity) {
        return entity != null && buttonEntityMapper.update(entity) > 0;
    }

    //========================== DELETE ==================

    @Transactional
    public void delete(ButtonEntity button) {
        //删除按钮：先删除sys_role_button表中所有button记录，然后删除sys_button中的记录.
        Long id = button.getId();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "button");
        List<Long> buttonIds = new ArrayList<>();
        buttonIds.add(id);
        parameters.put("list", buttonIds);
        //roleResourceMapper.deleteRoleResources(parameters);
        buttonEntityMapper.deleteByPrimaryKey(id);
    }
}
