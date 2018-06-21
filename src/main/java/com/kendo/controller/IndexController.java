package com.kendo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/home")
    public String index(Model model){
        model.addAttribute("message","Spring Boot!!");
        return "index";
    }

}