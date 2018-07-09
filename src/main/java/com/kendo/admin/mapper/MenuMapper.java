package com.kendo.admin.mapper;

import com.kendo.admin.BaseMapper;
import com.kendo.admin.bean.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kendone
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectMenuByUsername(String id);

    List<Menu> selectValidMenu();

    List<Menu> selectAll();

}