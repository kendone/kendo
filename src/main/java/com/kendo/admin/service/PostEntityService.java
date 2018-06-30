package com.kendo.admin.service;

import com.kendo.admin.BaseService;
import com.kendo.admin.bean.PostEntity;

import java.util.HashMap;

/**
 * @author kendone
 */
public interface PostEntityService extends BaseService<PostEntity> {

    HashMap<String, Object> findAll(Integer page, Integer pageSize);

}
