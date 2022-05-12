package com.web.entity;

import com.web.enums.ResultStatus;

/**
 * 服务端通用返回实体
 */
public class Result<T> {
    String taskId;
    String status;
    Integer code;
    String msg;
    T data;

    public Result() {
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setSuccess() {
        setCode(ResultStatus.SUCCESSED.getCode());
        setStatus(ResultStatus.SUCCESSED.getStatus());
    }

    public void setFailed() {
        setCode(ResultStatus.FAILED.getCode());
        setStatus(ResultStatus.FAILED.getStatus());
    }

    @Override
    public String toString() {
        return "Result{" +
                "taskId='" + taskId + '\'' +
                ", status='" + status + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
