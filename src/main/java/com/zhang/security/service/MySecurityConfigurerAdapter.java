package com.zhang.security.service;

import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

/**
 * @description: 继承SecurityConfigurerAdapter
 * @author: zhangFanJun
 * @create: 2022-01-12 00:14
 **/
@Service
public class MySecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Override
    public void configure(HttpSecurity http) throws Exception {

//        http.addFilterBefore(, UsernamePasswordAuthenticationFilter.class);
    }
}
