package com.kendo.admin.service;

import com.kendo.admin.BaseService;
import com.kendo.admin.bean.ButtonEntity;

import java.util.Map;

/**
 * @author kendone
 */
public interface ButtonEntityService extends BaseService<ButtonEntity> {

    Map<String, Object> findButtonByWindowId(Long windowId);

    void delete(ButtonEntity button);
}
