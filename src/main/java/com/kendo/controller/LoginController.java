package com.kendo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kendone
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String logined(Model model) {
        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }
}
