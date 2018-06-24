package com.kendo.admin.mapper;

import com.kendo.admin.bean.MenuItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuItemMapper {

    List<MenuItem> selectMenuItemByMenuId(Map<String, Object> parameters);
}
