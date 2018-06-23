package com.kendo.security.mapper;

import com.kendo.security.bean.Principal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrincipalMapper {

    Principal selectByUsername(String username);

}
