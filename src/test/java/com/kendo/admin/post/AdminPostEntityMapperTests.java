package com.kendo.admin.post;

import com.kendo.admin.bean.PostEntity;
import com.kendo.admin.mapper.PostEntityMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author kendone
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminPostEntityMapperTests {

    @Autowired
    private PostEntityMapper postEntityMapper;

    @Test
    public void selectAll() {
        List<PostEntity> postEntities = postEntityMapper.selectAll();
        Assert.assertFalse(postEntities.isEmpty());
    }
}
