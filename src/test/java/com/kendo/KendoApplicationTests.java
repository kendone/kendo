package com.kendo;

import com.kendo.bean.Principal;
import com.kendo.mapper.PrincipalMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KendoApplicationTests {

    @Autowired
    private PrincipalMapper principalMapper;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Test
    public void passwordEncoder() {
        System.out.println(bCryptPasswordEncoder.encode("admin"));
    }

    @Test
    public void selectByUsername() {
        Principal principal = principalMapper.selectByUsername("admin");
        principal = Objects.requireNonNull(principal, "admin not found!");
        System.out.println(principal.getName());
    }

}
