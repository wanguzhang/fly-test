package com.fly.test.module.mock.service;

import com.fly.test.module.mock.entity.MockBO;
import com.fly.test.module.mock.entity.MockDTO;
import com.fly.test.module.mock.manage.MockManage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @author 张攀钦
 * @date 2019-12-24-17:05
 * @description
 */
@SpringBootTest
class MockServiceImplTest {

    @Autowired
    private MockService mockService;

    @MockBean
    private MockManage mockManage;

    @Test
    void getMockBO() {
        String name="测试 Mock method";
        MockDTO mockDTO = new MockDTO();
        mockDTO.setName(name);

        MockBO mockBO=new MockBO();
        mockBO.setName(name);
        mockBO.setAge("返回固定年龄");
        Mockito.when(mockManage.getMockBO(mockDTO)).thenReturn(mockBO);

        Mockito.when(mockManage.getMockBO(ArgumentMatchers.any())).thenReturn(mockBO);

        MockDTO mockDTO2 = new MockDTO();
        mockDTO2.setName(name);
        MockBO mockBO1 = mockService.getMockBO(mockDTO2);
        Assert.assertEquals(mockBO,mockBO1);
    }
}