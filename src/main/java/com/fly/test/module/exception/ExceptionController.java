package com.fly.test.module.exception;

import com.fly.test.common.util.RetUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author 张攀钦
 * @date 2019-12-17-14:14
 * @description
 */
@RestController
public class ExceptionController {
    /**
     * 标记跑出日常
     */

    private static final String EXCEPTION = "exception";

    @GetMapping(value = "/exception")
    public RetUtil exception(String exception) {
        if (Objects.equals(EXCEPTION,exception)) {
            throw new MyException();
        }
        return RetUtil.ok(exception);
    }
}
