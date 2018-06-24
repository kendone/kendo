package com.kendo.security;

import com.kendo.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author kendone
 */
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/index")
    public String index(Model model) {
        String username;
        Object p = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (p instanceof UserDetails) {
            username = ((UserDetails) p).getUsername();
        } else {
            username = p.toString();
        }

        System.out.println("current user:" + username);

        //List<Menu> menus = menuService.findAsideMenusByUsername('admin');
        //List<Menu> menus = menuService.findAsideMenusByUserId(2L);
        //model.addAttribute("menus", menus);
        return "index";
    }
}
