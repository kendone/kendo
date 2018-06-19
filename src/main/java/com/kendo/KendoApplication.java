package com.kendo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class KendoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KendoApplication.class, args);
    }
}