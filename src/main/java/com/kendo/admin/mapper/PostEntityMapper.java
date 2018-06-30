package com.kendo.admin.mapper;

import com.kendo.admin.BaseMapper;
import com.kendo.admin.bean.PostEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kendone
 */
@Mapper
public interface PostEntityMapper extends BaseMapper<PostEntity> {

    List<PostEntity> selectAll();
}
