package com.web.exceptions;

/**
 * 全局通用异常类
 */
public class CommonException extends RuntimeException {
    private Integer code;
    public CommonException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}

