package com.fly.test.module.mock.service;

import com.fly.test.module.mock.entity.MockBO;
import com.fly.test.module.mock.entity.MockDTO;
import com.fly.test.module.mock.manage.MockManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张攀钦
 * @date 2019-12-24-17:01
 * @description
 */
@Service
public class MockServiceImpl implements MockService {

    @Autowired
    private MockManage mockManage;

    @Override
    public MockBO getMockBO(MockDTO mockDTO) {
        return mockManage.getMockBO(mockDTO);
    }
}
