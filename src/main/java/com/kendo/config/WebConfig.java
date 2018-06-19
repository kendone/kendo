package com.kendo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 * @author kendone
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/admin/home").setViewName("adminhome");
//        registry.addViewController("/accessDenied").setViewName("403");
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    //    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("==================================================");
//        registry.addResourceHandler("/assets/")
//                .addResourceLocations("classpath:/static/");
//        System.out.println("==================================================");
//    }
}
