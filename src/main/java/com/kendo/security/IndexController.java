package com.kendo.security;

import com.kendo.admin.bean.Menu;
import com.kendo.admin.bean.MenuWindows;
import com.kendo.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kendone
 */
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/index")
    public String index(Model model) {
        String username = getCurrentUser();

        System.out.println("current user:" + username);

        List<Menu> menus = menuService.findMenuByUsername(username);
        model.addAttribute("menus", menus);
        return "index";
    }

    private String getCurrentUser() {
        String username;
        Object p = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (p instanceof UserDetails) {
            username = ((UserDetails) p).getUsername();
        } else {
            username = p.toString();
        }
        return username;
    }

    @PostMapping(value = "/menu/navigation-menus")
    public @ResponseBody MenuWindows findMenus(@RequestParam("menuId") Long menuId) {
        String userId = getCurrentUser();
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("menuId", menuId);
        parameters.put("userId", userId);
        return menuService.findMenuWindowsByMenuId(parameters);
    }
}
