package com.fly.test.module.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 张攀钦
 * @date 2019-12-17-15:51
 * @description
 */
@SpringBootTest
class ExceptionServiceImplTest {

    @Autowired
    private ExceptionServiceImpl exceptionService;

    /**
     * 测试正常逻辑
     */
    @Test
    void shopping() {
        int shopping = exceptionService.shopping(20);
        assertEquals(1,shopping);
    }

    /**
     * 测试异常逻辑，花钱超过2000 报错
     * 花费 20000
     */
    @Test
    public void shopping_throwException() {

        // 测试 junit 5 的用法
        MyException myException = Assertions.assertThrows(MyException.class, () -> {
            exceptionService.shopping(20000);
        });

        Assertions.assertNotNull(myException);
        Assertions.assertEquals(200,myException.getCode());
    }
}