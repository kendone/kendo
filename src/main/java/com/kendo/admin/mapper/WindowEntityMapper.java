package com.kendo.admin.mapper;

import com.kendo.admin.BaseMapper;
import com.kendo.admin.bean.WindowEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kendone
 */
@Mapper
public interface WindowEntityMapper extends BaseMapper<WindowEntity> {

    List<WindowEntity> find(@Param("window") WindowEntity window);

    List<WindowEntity> selectValidWindowByWindowId(@Param("windowId") Long windowId);

//    @Deprecated
    List<WindowEntity> selectValidWindow();
}