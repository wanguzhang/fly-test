package com.fly.test.module.user.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2019-11-03-19:00
 * @description 对应用户表 的 DO
 */
@Data
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1485840423414474928L;
    private Integer id;
    private String username;
    private String password;
}
