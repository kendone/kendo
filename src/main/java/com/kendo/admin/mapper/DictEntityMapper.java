package com.kendo.admin.mapper;

import com.kendo.admin.BaseMapper;
import com.kendo.admin.bean.DictEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kendone
 */
@Mapper
public interface DictEntityMapper extends BaseMapper<DictEntity> {

    List<DictEntity> selectAll();

}