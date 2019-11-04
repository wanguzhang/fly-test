package com.fly.test.module.user.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2019-11-03-19:07
 * @description 接受用户名和密码
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 2220468929024395587L;
    private String username;
    private String password;
}
