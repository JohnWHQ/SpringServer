package com.web.entity;

/**
 * 请求接受实体类示例
 */
public class Request {
    Integer id;
    String key;
    String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
