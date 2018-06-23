package com.kendo.admin.service;


import com.kendo.admin.BaseService;
import com.kendo.admin.bean.WindowEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @author kendone
 */
public interface WindowEntityService extends BaseService<WindowEntity> {

    HashMap<String, Object> find(Integer page, Integer pageSize);

    HashMap<String, Object> find(WindowEntity window, Integer page, Integer pageSize);

    List<WindowEntity> find(WindowEntity window);

    List<WindowEntity> findValidWindowByWindowId(Long id);

    @Deprecated
    List<WindowEntity> findValidWindow();
}
