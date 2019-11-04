package com.fly.test.common.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2019-11-03-19:09
 * @description 统一接口返回值
 */
@Data
public class RetUtil<T> implements Serializable {
    private static final long serialVersionUID = -8506384833974527860L;

    private static final Integer SUCCESS_CODE = 200;

    private Integer code;

    private String message;

    private T data;

    public static <T> RetUtil<T> ok() {
        final RetUtil<T> ok = new RetUtil<>();
        ok.setCode(SUCCESS_CODE);
        return ok;
    }

    public static <T> RetUtil<T> ok(T t) {
        final RetUtil<T> ok = new RetUtil<>();
        ok.setCode(SUCCESS_CODE);
        ok.setData(t);
        return ok;
    }

    public static <T> RetUtil<T> build(T t) {
        final RetUtil<T> ok = new RetUtil<>();
        ok.setData(t);
        return ok;
    }

    public RetUtil<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public RetUtil<T> data(T t) {
        this.setData(t);
        return this;
    }

    public RetUtil<T> message(String message) {
        this.setMessage(message);
        return this;
    }
}
