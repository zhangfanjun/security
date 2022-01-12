package com.zhang.security.controller;

import com.zhang.security.coommon.model.ResponseVO;
import com.zhang.security.coommon.model.request.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:用户
 * @author: zhangFanJun
 * @create: 2021-12-16 22:44
 **/
@Slf4j
@RestController
//@RequestMapping("/my/user")
@RequestMapping("/user")
public class UserController {


    /**
     * 登录的意义就是跟token解析相关的，因为鉴权不交给spring security管理，
     * 所以登录就是为了生成一个有效的token
     * */
    @RequestMapping("/login")
    public ResponseVO login(@RequestBody LoginDTO in){
        log.info("{}用户登录",in.getUserName());
        return ResponseVO.success();
    }

    @GetMapping("/getName")
    public Object getName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return principal;
    }
}
