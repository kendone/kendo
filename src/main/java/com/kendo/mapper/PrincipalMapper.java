package com.kendo.mapper;

import com.kendo.bean.Principal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrincipalMapper {

    Principal selectByUsername(String username);

}
