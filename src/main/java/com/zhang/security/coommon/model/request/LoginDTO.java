package com.zhang.security.coommon.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户登录请求
 * @author: zhangFanJun
 * @create: 2021-12-16 23:00
 **/
@Data
public class LoginDTO implements Serializable {
    /**
     * 账号
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
}
