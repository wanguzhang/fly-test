package com.fly.test.module.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张攀钦
 * @date 2019-12-17-14:16
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {
    private int code;
    private String message;
    private static final long serialVersionUID = 1398894550795293308L;
}
