package com.zhang.security.config;

import com.zhang.security.service.MyAccessDeniedHandler;
import com.zhang.security.service.MyAuthenticationEntryPoint;
import com.zhang.security.service.MySecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * @description: spring鉴权的配置
 * @author: zhangFanJun
 * @create: 2021-12-16 23:14
 **/
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 由MyCorsFilter生成bean
     */
    @Autowired
    private CorsFilter corsFilter;
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;
    @Autowired
    private MySecurityConfigurerAdapter mySecurityConfigurerAdapter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
                //关闭原生的跨域，替换用创建的跨域
                .cors().disable().addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                //异常的处理
                .exceptionHandling()
                // 权限不正确
                .accessDeniedHandler(myAccessDeniedHandler)
                // 没有令牌
                .authenticationEntryPoint(myAuthenticationEntryPoint)
                .and()
                //支持csrf
                .csrf()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                //不启用spring security的session共享
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //配置接口的权限
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("my/login").permitAll()
                //这里不采用role的方式，因为user的保存是权限，而不是角色，spring中可以配置用户的角色
                .antMatchers("my/admin").hasAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .apply(mySecurityConfigurerAdapter);
    }
}
