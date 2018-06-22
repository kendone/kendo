package com.kendo.admin.mapper;

import com.kendo.admin.bean.ButtonEntity;
import com.kendo.admin.bean.WindowEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminWindowAppTests {

    @Autowired
    private WindowEntityMapper windowEntityMapper;

    @Test
    public void selectValidWindow(){
        List<WindowEntity> windowEntities = windowEntityMapper.selectValidWindow();
        Assert.assertEquals(2,windowEntities.size());
    }

}
