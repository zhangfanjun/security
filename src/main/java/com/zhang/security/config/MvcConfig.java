package com.zhang.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 视图配置，为了请求能转发到对应的视图
 * @author: zhangFanJun
 * @create: 2021-12-16 23:54
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/home").setViewName("home");
            registry.addViewController("/").setViewName("home");
            registry.addViewController("/hello").setViewName("hello");
            registry.addViewController("/login").setViewName("login");
        }
}
