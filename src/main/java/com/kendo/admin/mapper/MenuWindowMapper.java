package com.kendo.admin.mapper;

import com.kendo.admin.bean.MenuWindow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuWindowMapper {

    List<MenuWindow> selectMenuWindowByMenuId(Map<String, Object> parameters);
}
