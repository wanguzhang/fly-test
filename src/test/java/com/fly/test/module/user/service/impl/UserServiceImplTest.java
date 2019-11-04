package com.fly.test.module.user.service.impl;

import com.fly.test.module.user.dao.UserDao;
import com.fly.test.module.user.entity.UserDO;
import com.fly.test.module.user.entity.UserDTO;
import com.fly.test.module.user.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 张攀钦
 * @date 2019-11-04-00:14
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    /**
     * 保存数据使用的 DTO
     */
    private UserDTO userDTO;

    /**
     * 保存数据之后返回的数据
     */
    private UserDO userDO;

    @Before
    public void before(){
        userDTO=new UserDTO();
        userDTO.setPassword("用户名");
        userDTO.setPassword("密码");

        userDO=new UserDO();
        userDO.setPassword("用户名");
        userDO.setPassword("密码");
        userDO.setId(1);
    }

    /**
     * 保存数据，回显数据 id 不为空
     */

    @Test
    public void insert() {
         Mockito.when(userDao.insert(ArgumentMatchers.any())).thenAnswer(invocation->{
             final UserDO argument = invocation.getArgument(0);
             argument.setId(1);
             return 1;
         }).thenReturn(1);

         UserDO insert = userService.insert(userDTO);
         Mockito.verify(userDao,Mockito.times(1)).insert(ArgumentMatchers.any());
         Assert.assertEquals(userDO,insert);
    }

    /**
     * 删除主键为 1 的数据，返回值 1 ，测试通过
     */

    @Test
    public void deleteUserById() {
        Mockito.when(userDao.deleteUserById(1)).thenReturn(1);
        final int i = userService.deleteUserById(1);
        Assert.assertEquals(1,i);
    }

    /**
     * 根据主键 id 查询数据
     */

    @Test
    public void getUserId() {
        Mockito.when(userDao.getUserId(1)).thenReturn(userDO);
        final UserDO userId = userService.getUserId(1);
        Assert.assertEquals(userId,userDO);
    }
}