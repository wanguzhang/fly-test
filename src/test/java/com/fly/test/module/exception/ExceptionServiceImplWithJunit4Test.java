package com.fly.test.module.exception;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 张攀钦
 * @date 2019-12-17-15:58
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionServiceImplWithJunit4Test {
    @Autowired
    private ExceptionServiceImpl exceptionService;
    /**
     * 基于 junit 4 测试
     */

    @org.junit.Test(expected=MyException.class)
    public void shopping_throwExceptionWithJunit4() {
        exceptionService.shopping(20000);
    }
}
