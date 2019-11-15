package com.fly.test.module.user.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.fly.test.module.user.dao.UserDao;
import com.fly.test.module.user.entity.UserDO;
import com.fly.test.module.user.entity.UserDTO;
import com.fly.test.module.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张攀钦
 * @date 2019-11-03-19:02
 * @description 用户管理 业务层实现类
 */
@Service
public class UserServiceImpl
        implements UserService {

    @Autowired
    private UserDao userDao;

    /***
     * 调用远程接口的用户信息
     * @author 张攀钦
     * @date 2019/11/15-14:36
     * @title getRemoteUser
     * @param id
     * @return com.fly.test.module.user.entity.UserDO
     *
     */
    @Override
    public UserDO getRemoteUser(Integer id) {
        String s = HttpUtil.get("http://localhost:8080");
        return JSON.parseObject(s, UserDO.class);
    }

    /***
     * 主要用来测试无用数据
     * @author 张攀钦
     * @date 2019/11/15-14:38
     * @title reruenVoid
     *
     */
    @Override
    public void returnVoid() {

        System.out.println("双11 买了好多东西");
    }

    @Override
    public UserDO insert(UserDTO userDTO) {
        final UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO,userDO);
        userDao.insert(userDO);
        return userDO;
    }

    @Override
    public int deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public UserDO getUserId(Integer id) {
       return userDao.getUserId(id);
    }
}
