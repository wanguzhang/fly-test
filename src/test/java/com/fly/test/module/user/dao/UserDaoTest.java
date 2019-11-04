package com.fly.test.module.user.dao;


import com.fly.test.module.user.entity.UserDO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 张攀钦
 * @date 2019-11-03-23:42
 * @description 数据库中保存主键 id 为 1，2，3 三条数据
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    /**
     * 保存数据用的 id
     */

    private UserDO userDO;

    /**
     * 查询数据校验
     */
    private UserDO userDO2;


    @Before
    public void before(){
        userDO=new UserDO();
        userDO.setUsername("测试保存用户-用户名");
        userDO.setPassword("测试保存用户名-密码");

        userDO2=new UserDO();
        userDO2.setUsername("测试保存用户-用户名");
        userDO2.setPassword("测试保存用户名-密码");
        userDO2.setId(2);
    }


    /**
     * 保存一条数据，返回值为 1 且 主键 id 回显标识成功
     */

    @Test
    public void insert() {
        final int insert = userDao.insert(userDO);
        Assert.assertEquals(1,insert);
        Assert.assertNotNull(userDO.getId());
    }

    /**
     * 删除数据库中主键 为 1 的数据，返回值为 1 ，标识删除成功
     */

    @Test
    public void deleteUserById() {
        final int i = userDao.deleteUserById(1);
        Assert.assertEquals(1,i);
    }

    /**
     * 查询数据库中主键 id 为 2 的数据
     */

    @Test
    public void getUserId() {
        final UserDO userId = userDao.getUserId(2);
        Assert.assertEquals(userDO2,userId);
    }
}