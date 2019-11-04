package com.fly.test.module.user.dao;

import com.fly.test.module.user.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 张攀钦
 * @date 2019-11-03-18:59
 * @description 用户管理数据持久层
 */
@Mapper
public interface UserDao {

    /***
     * 保存单个用户
     * @author 张攀钦
     * @date 2019/11/3-23:32
     * @title insert
     * @param userDO
     * @return int
     */

    int insert(@Param("userDO") UserDO userDO);

    /***
     * 删除单个用户
     * @author 张攀钦
     * @date 2019/11/3-23:33
     * @title deleteUserById
     * @param id
     * @return int
     */

    int deleteUserById(@Param("id") Integer id);

    /**
     * 获取单个用户
     * @author 张攀钦
     * @date 2019/11/3-23:34
     * @title getUserId
     * @param id
     * @return com.fly.test.module.user.entity.UserDO
     */

    UserDO getUserId(@Param("id") Integer id);
}
