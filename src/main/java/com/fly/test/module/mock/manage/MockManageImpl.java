package com.fly.test.module.mock.manage;

import com.fly.test.module.mock.entity.MockBO;
import com.fly.test.module.mock.entity.MockDTO;
import org.springframework.stereotype.Component;

/**
 * @author 张攀钦
 * @date 2019-12-24-17:04
 * @description
 */
@Component
public class MockManageImpl implements MockManage {
    @Override
    public MockBO getMockBO(MockDTO mockDTO) {
        MockBO mockBO = new MockBO();
        mockBO.setName(mockDTO.getName());
        mockBO.setAge("返回固定年龄");
        return mockBO;
    }
}
