package com.kendo;

import com.kendo.bean.Rank;
import com.kendo.mapper.RankMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KendoApplicationTests {

    @Autowired
    private RankMapper rankMapper;

    @Test
    public void findAllRanks(){
        List<Rank> ranks = rankMapper.selectAll();
        assertNotNull(ranks);
    }

}
