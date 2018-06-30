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

    //根据用户查询顶级菜单
    List<Menu> selectMenuByUsername(String id);

    //根据角色查询用户的菜单,目前没有和角色进行关联后期补充
    List<Menu> selectValidMenu();

    //查询所有菜单
    List<Menu> selectAll();

}