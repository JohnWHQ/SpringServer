package com.web.enums;

/**
 * Created by wanghanqi on 2019/10/23.
 */
public enum ResultStatus {

    SUCCESSED("SUCCESSED", 0),
    FAILED("FAILED", -1);

    String status;
    Integer code;

    ResultStatus(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResultStatus{" +
                "status='" + status + '\'' +
                ", code=" + code +
                '}';
    }
}
