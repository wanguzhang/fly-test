package com.fly.test.module.mock.service;

import com.fly.test.module.mock.entity.MockBO;
import com.fly.test.module.mock.entity.MockDTO;

/**
 * @author 张攀钦
 * @date 2019-12-24-16:58
 * @description 介绍 mock
 */
public interface MockService {
    MockBO getMockBO(MockDTO mockDTO);
}
