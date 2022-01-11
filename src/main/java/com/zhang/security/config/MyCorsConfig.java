package com.zhang.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @description: 跨域请求
 * @author: zhangFanJun
 * @create: 2022-01-11 22:25
 **/
@Configuration
public class MyCorsConfig {

    @Bean
    public CorsFilter getMyCorsFilter(){
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 请求方式，允许任意的请求头，任意的请求方式，任意的请求域名
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        // 采用标准的鉴权请求头
        corsConfiguration.setAllowCredentials(true);
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/my/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
