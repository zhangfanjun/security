package com.zhang.security.coommon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:请求响应
 * @author: zhangFanJun
 * @create: 2021-12-16 22:46
 **/
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseVO<T> implements Serializable {
    /**
     * 响应编码
     */
    private Integer code = 200;
    /**
     * 异常信息
     */
    private String msg;
    /**
     * 响应内容
     */
    private T content;

    /**
     * 成功
     */
    public static ResponseVO success() {
        return new ResponseVO();
    }
}
