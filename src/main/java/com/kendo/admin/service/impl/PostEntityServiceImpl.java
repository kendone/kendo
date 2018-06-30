package com.kendo.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kendo.admin.bean.PostEntity;
import com.kendo.admin.mapper.PostEntityMapper;
import com.kendo.admin.service.PostEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author kendone
 */
@Service
public class PostEntityServiceImpl implements PostEntityService {

    @Autowired
    private PostEntityMapper postEntityMapper;

    @Override
    public HashMap<String, Object> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<PostEntity> items = postEntityMapper.selectAll();
        PageInfo<PostEntity> pageInfo = new PageInfo<>(items);
        Long itemCount = pageInfo.getTotal();
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("items", items);
        dataMap.put("itemCount", itemCount);
        return dataMap;
    }

    @Override
    public PostEntity get(final Long id) {
        return postEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public PostEntity add(final PostEntity entity) {
        postEntityMapper.insertIgnoreNull(entity);
        return entity;
    }

    @Override
    public boolean update(final PostEntity entity) {
        return postEntityMapper.update(entity) > 0;
    }

    @Override
    public void delete(final PostEntity entity) {
        postEntityMapper.deleteByPrimaryKey(entity.getId());
    }
}
