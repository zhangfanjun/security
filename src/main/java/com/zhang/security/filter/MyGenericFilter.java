package com.zhang.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

/**
 * @description: 添加一个过滤器用于处理token信息
 * @author: zhangFanJun
 * @create: 2022-01-12 22:26
 **/
@Slf4j
public class MyGenericFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String bearToken = request.getHeader("Authorization");
        String requestURI = request.getRequestURI();
        log.info("bearToken:{},uri:{}",bearToken, requestURI);


        //将解析完成的用户名放到线程中，接下去在UsernamePasswordAuthenticationFilter中执行用户名查找对应的用户信息
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("admin");
        authorities.add(simpleGrantedAuthority);
        User user = new User("testname", "123", authorities);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user,"token",authorities);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //这里不做token的校验，直接通行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
