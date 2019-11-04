package com.fly.test.module.user.controller;

import com.fly.test.module.user.entity.UserDO;
import com.fly.test.module.user.entity.UserDTO;
import com.fly.test.module.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @author 张攀钦
 * @date 2019-11-04-20:28
 * @description 用户管理单元测试
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private UserDTO userDTO;

    private UserDO userDO;

    @Before
    public void before(){
        userDO=new UserDO();
        userDO.setId(1);
        userDO.setPassword("password");
        userDO.setUsername("username");

        userDTO=new UserDTO();
        userDTO.setPassword("password");
        userDTO.setUsername("username");
    }

    /**
     * 测试保存用户数据
     */
    @Test
    public void insert() throws Exception {
        Mockito.when(userService.insert(userDTO)).thenReturn(userDO);
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"username\":\"username\",\"password\":\"password\"}")
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.username").value("username"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.password").value("password"));
    }

    /**
     * 删除用户数据,删除主键 id 为 1 的数据
     */

    @Test
    public void deleteUser() throws Exception {
        Mockito.when(userService.deleteUserById(1)).thenReturn(1);
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200));
        Mockito.verify(userService,Mockito.times(1)).deleteUserById(1);
    }

    /**
     * 查询主键 为 1数据
     */

    @Test
    public void getUserById() throws Exception {
        Mockito.when(userService.getUserId(1)).thenReturn(userDO);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.username").value("username"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.password").value("password"));

    }
}