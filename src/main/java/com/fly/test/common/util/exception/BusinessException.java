package com.fly.test.common.util.exception;

import lombok.Data;
import org.springframework.web.util.NestedServletException;

/**
 * @author 张攀钦
 * @date 2019-11-15-14:16
 * @description 业务异常
 */
@Data
public class BusinessException extends NestedServletException {
    /**
     * //    异常提示信息
     */
    private String message;

    /**
     * 业务状态码
     */

    private Integer code;

    public BusinessException(String message,Integer code){
        super(message);
        this.message=message;
        this.code=code;
    }
}
