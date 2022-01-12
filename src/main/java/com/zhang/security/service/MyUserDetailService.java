package com.zhang.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @description: 用户详情，在校验用户的时候，会对比用户的密码，如果相同，就会采用当前的UserDetails
 * @author: zhangFanJun
 * @create: 2022-01-11 22:26
 **/
@Slf4j
@Service("userDetailService")
public class MyUserDetailService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    /**
    * 任意的名字登录，最后密码都是123，权限都是admin
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername:{}",username);
        String password = passwordEncoder.encode("123");
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("admin");
        authorities.add(role);
        User user = new User("testname",password,authorities);
        return user;
    }
}
