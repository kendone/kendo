package com.kendo.admin.mapper;

import com.kendo.admin.BaseMapper;
import com.kendo.admin.bean.ButtonEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kendone
 */
@Mapper
public interface ButtonEntityMapper extends BaseMapper<ButtonEntity> {

    List<ButtonEntity> selectByWindowId(Long windowId);

}