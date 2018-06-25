package com.kendo;

import com.kendo.admin.bean.Menu;
import com.kendo.admin.mapper.MenuMapper;
import com.kendo.security.bean.Principal;
import com.kendo.security.mapper.PrincipalMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KendoApplicationTests {

    @Autowired
    private PrincipalMapper principalMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Test
    public void selectAll(){
        List<Menu> menus = menuMapper.selectAll();
        System.out.println(menus.get(0).getCreateUser().getUsername());
    }

    @Test
    public void passwordEncoder() {
        System.out.println(bCryptPasswordEncoder.encode("kendo"));
    }

    @Test
    public void selectByUsername() {
        Principal principal = principalMapper.selectByUsername("admin");
        principal = Objects.requireNonNull(principal, "admin not found!");
        System.out.println(principal.getName());
        principal.getRoles().forEach((role -> System.out.println(role.getName())));
    }

}
