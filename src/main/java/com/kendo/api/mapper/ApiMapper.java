package com.kendo.api.mapper;

import com.kendo.api.bean.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiMapper {

    List<Rank> selectValidRanks();

    List<Dept> selectValidDepts();

    Dept selectValidDeptByUserId(Long userId);

    List<Post> selectValidPosts();

    List<Dict> selectValidDictByType(String type);

    List<Window> selectValidWindow();
}
