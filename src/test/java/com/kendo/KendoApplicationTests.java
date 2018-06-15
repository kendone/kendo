package com.kendo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KendoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() {
        List<User> users = userRepository.findAll();
        //users.forEach(System.out::println);
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }

    @Test
    public void contextLoads() {
    }

}
