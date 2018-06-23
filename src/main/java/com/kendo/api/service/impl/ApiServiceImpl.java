package com.kendo.api.service.impl;

import com.kendo.api.bean.*;
import com.kendo.api.mapper.ApiMapper;
import com.kendo.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiMapper apiMapper;

    @Override
    public List<Rank> findValidRank() {
        return apiMapper.selectValidRanks();
    }

    @Override
    public List<Dept> findValidDept() {
        return apiMapper.selectValidDepts();
    }

    @Override
    public Dept getValidDeptByUserId(Long userId) {
        return apiMapper.selectValidDeptByUserId(userId);
    }

    @Override
    public List<Post> findValidPost() {
        return apiMapper.selectValidPosts();
    }

    @Override
    public List<Dict> findValidDictByType(String type) {
        return apiMapper.selectValidDictByType(type);
    }

    @Override
    public List<Window> findValidWindow() {
        return apiMapper.selectValidWindow();
    }
}
