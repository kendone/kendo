package com.kendo.admin.service;

import com.kendo.admin.BaseService;
import com.kendo.admin.bean.DictEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @author kendone
 */
public interface DictEntityService extends BaseService<DictEntity> {

    HashMap<String, Object> findPage(Integer page, Integer pageSize);

    List<DictEntity> findAll();
}
