package com.fly.test.module.user.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.fly.test.SpringTestApplication;
import com.fly.test.common.util.exception.BusinessException;
import com.fly.test.module.user.entity.UserDO;
import com.fly.test.module.user.entity.UserDTO;
import com.fly.test.module.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author 张攀钦
 * @date 2019-11-04-20:28
 * @description 用户管理单元测试
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
// 带有@SpringBootApplication 的主类
@SpringBootTest(classes = {SpringTestApplication.class})
// 将需要模拟的工具类加入其中
@PrepareForTest(value={HttpUtil.class})
// MockClassLoader 加载类忽略 PowerMockIgnore 配置的包，让系统类加载器加载，当出现类加载报错的时候，在这里排除包
@PowerMockIgnore({"javax.management.*", "javax.net.ssl.*"})
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    private UserDTO userDTO;

    private UserDO userDO;



    @Before
    public void before(){

        /**
         * 使用 api 模拟一个 MockMvc
         */
        mockMvc=MockMvcBuilders.standaloneSetup(userController).build();


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
                .contentType(MediaType.APPLICATION_JSON)
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
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200));
        Mockito.verify(userService,Mockito.times(1)).deleteUserById(1);
    }

    /**
     * 查询主键 为 1数据
     */

    @Test
    public void getUserById() throws Exception {
        Mockito.when(userService.getUserId(1)).thenReturn(userDO);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.username").value("username"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.password").value("password"));

    }

    /**
     * 模拟一个异常显示,业务逻辑
     * 传入正常参数 1 ，单测正常逻辑，不抛出异常，接口状态码为 200
     */
    @Test
    public void throwException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/exception/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200));
    }

    /**
     * 模拟一个异常显示,业务逻辑
     * 传入异常参数 2222 ，单测抛出异常，接口状态码
     */
    @Test(expected = BusinessException.class)
    public void throwExceptionThrowException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/exception/2222").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200));
    }
    /**
     * 在 controller 调用静态方法示例展示,调用 http 请求 http://localhost:8080/1
     */
    @Test
    public void staticMethod() throws Exception {
        PowerMockito.mockStatic(HttpUtil.class);
        Integer id=1;
        Mockito.when(HttpUtil.get("http://localhost:8080/"+id)).thenReturn(JSON.toJSONString(userDO));
        mockMvc.perform(MockMvcRequestBuilders.get("/users/static-method/{id}",id).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(userDO.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.password").value(userDO.getPassword()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.username").value(userDO.getUsername()));
    }

    /**
     * 模拟无返回值的 service 进行单元测试
     */

    @Test
    public void noReturn() throws Exception {
        Mockito.doNothing().when(userService).returnVoid();
        mockMvc.perform(MockMvcRequestBuilders.get("/users/no-return").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200));
        Mockito.verify(userService,Mockito.times(1)).returnVoid();
    }
}