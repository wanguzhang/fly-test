package com.fly.test.module.user.service;

import com.fly.test.module.user.entity.UserDO;
import com.fly.test.module.user.entity.UserDTO;

/**
 * @author 张攀钦
 * @date 2019-11-03-19:01
 * @description 用户管理业务层
 */
public interface UserService {
    /***
     * 保存用户
     * @author 张攀钦
     * @date 2019/11/3-19:23
     * @title insert
     * @param userDTO
     * @return com.fly.test.module.user.entity.UserDO
     */
    UserDO insert(UserDTO userDTO);

    /***
     * 根据用户 id 删除用户数据
     * @author 张攀钦
     * @date 2019/11/3-19:26
     * @title deleteUserById
     * @param id
     * @return int
     */
    int deleteUserById(Integer id);

    /***
     * 根据用户 id 查询用户数据
     * @author 张攀钦
     * @date 2019/11/3-19:29
     * @title getUserId
     * @param id
     * @return com.fly.test.module.user.entity.UserDO
     */

    UserDO getUserId(Integer id);
}
