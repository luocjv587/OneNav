package com.example.navigation.model.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.model.exception
 * <p>
 * DateTime: 2021-11-22 12:55 下午
 *
 * @author luocj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessException extends RuntimeException {
    /**
     * 返回数据
     */
    private Object data;

    /**
     * 错误异常code
     */
    private Integer errRode;

    /**
     * 错误异常信息
     */
    private String errMsg;

    public BusinessException(Object obj, String msg, int code) {
        this.data = obj;
        this.errMsg = msg;
        this.errRode = code;
    }

    public BusinessException(String msg) {
        this.errMsg = msg;
        this.errRode = 100;
    }

    public BusinessException(String msg, int code) {
        this.errMsg = msg;
        this.errRode = code;
    }


}
