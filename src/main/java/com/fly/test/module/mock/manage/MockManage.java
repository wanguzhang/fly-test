package com.fly.test.module.mock.manage;

import com.fly.test.module.mock.entity.MockBO;
import com.fly.test.module.mock.entity.MockDTO;

/**
 * @author 张攀钦
 * @date 2019-12-24-17:03
 * @description 测试模拟
 */
public interface MockManage {
    /***
     * 测试模拟使用
     * @author 张攀钦
     * @date 2019/12/24-17:04
     * @title getMockBO
     * @param mockDTO
     * @return com.fly.test.module.mock.entity.MockBO
     *
     */

    MockBO getMockBO(MockDTO mockDTO);
}
