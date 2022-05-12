package com.web.exceptions;

/**
 * Created by wanghanqi on 2019/10/26.
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

