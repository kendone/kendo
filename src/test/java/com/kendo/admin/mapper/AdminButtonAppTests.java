package com.kendo.admin.mapper;

import com.kendo.admin.bean.ButtonEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminButtonAppTests {

    @Autowired
    private ButtonEntityMapper buttonEntityMapper;

    @Test
    public void selectByWindowId(){
        List<ButtonEntity> buttonEntities = buttonEntityMapper.selectByWindowId(9L);
        Assert.assertEquals(2,buttonEntities.size());
    }

    @Test
    public void selectByPrimaryKey(){
        ButtonEntity buttonEntity = buttonEntityMapper.selectByPrimaryKey(1L);
        Assert.assertNotNull(buttonEntity);
        System.out.println(buttonEntity.getName());
    }
}
