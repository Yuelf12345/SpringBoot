package com.example.yue.utils;

import org.springframework.http.HttpStatus;

public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //    请求成功
    public static <T> Result<T> success(T data) {
        return new Result<>(HttpStatus.OK.value(), "success!", data);
    }

// 请求失败
    public static <T> Result<T> fail(Integer code,String message) {
        return new Result<>(code, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
