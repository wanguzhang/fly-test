package com.fly.test.module.exception;

import org.springframework.stereotype.Service;

/**
 * @author 张攀钦
 * @date 2019-12-17-15:47
 * @description
 */
@Service
public class ExceptionServiceImpl {

    public int shopping(int count){
        if(count>2000){
            throw new MyException(200,"花钱太多了");
        }
        return 1;
    }
}
