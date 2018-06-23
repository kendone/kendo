package com.kendo.api.service;


import com.kendo.api.bean.*;

import java.util.List;

public interface ApiService {

    List<Rank> findValidRank();

    List<Dept> findValidDept();

    Dept getValidDeptByUserId(Long userId);

    List<Post> findValidPost();

    List<Dict> findValidDictByType(String type);

    List<Window> findValidWindow();
}
