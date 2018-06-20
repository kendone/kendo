package com.kendo.mapper;

import com.kendo.bean.Rank;
import com.kendo.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kendone
 */
@Mapper
public interface RankMapper extends BaseMapper<Rank> {

    List<Rank> selectValidRanks();

    List<Rank> selectAll();
}