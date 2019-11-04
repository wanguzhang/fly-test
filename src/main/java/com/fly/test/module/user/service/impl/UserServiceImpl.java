package com.fly.test.module.user.service.impl;

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
