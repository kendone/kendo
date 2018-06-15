package com.kendo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class KendoApplication {

    @RequestMapping("/")
    String home(){
        return "Hello World!!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(KendoApplication.class, args);
    }
}
