package com.zhang.security.controller;

import com.zhang.security.coommon.model.ResponseVO;
import com.zhang.security.coommon.model.request.LoginDTO;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/login")
    public ResponseVO login(@RequestBody LoginDTO in){
        log.info("{}用户登录",in.getUserName());
        return ResponseVO.success();
    }

}
