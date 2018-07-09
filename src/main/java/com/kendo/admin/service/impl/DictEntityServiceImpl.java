package com.kendo.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kendo.admin.bean.DictEntity;
import com.kendo.admin.mapper.DictEntityMapper;
import com.kendo.admin.service.DictEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author kendone
 */
@Service
public class DictEntityServiceImpl implements DictEntityService {

    @Autowired
    private DictEntityMapper dictEntityMapper;

    @Override
    public List<DictEntity> findAll() {
        return dictEntityMapper.selectAll();
    }

    @Override
    public HashMap<String, Object> findPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<DictEntity> items = dictEntityMapper.selectAll();
        PageInfo<DictEntity> pageInfo = new PageInfo<>(items);
        Long itemCount = pageInfo.getTotal();
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("items", items);
        dataMap.put("itemCount", itemCount);
        return dataMap;
    }

    @Override
    public DictEntity get(Long id) {
        return dictEntityMapper.selectByPrimaryKey(id);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public DictEntity add(DictEntity entity) {
        dictEntityMapper.insertIgnoreNull(entity);
        return entity;
    }

    @Override
    public boolean update(DictEntity entity) {
        return dictEntityMapper.update(entity) > 0;
    }

    @Override
    public void delete(DictEntity entity) {
        dictEntityMapper.deleteByPrimaryKey(entity.getId());
    }
}
