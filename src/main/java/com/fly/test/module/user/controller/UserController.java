package com.fly.test.module.user.controller;

import com.fly.test.common.util.RetUtil;
import com.fly.test.module.user.entity.UserDO;
import com.fly.test.module.user.entity.UserDTO;
import com.fly.test.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张攀钦
 * @date 2019-11-03-18:58
 * @description 用户管理
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 保存用户
     */

    @PostMapping(value = "/users")
    public RetUtil<UserDO> insert(@RequestBody UserDTO userDTO){
        UserDO userDO=userService.insert(userDTO);
        return RetUtil.ok(userDO);
    }

    /**
     * 删除用户
     */

    @DeleteMapping(value = "/users/{id}")
    public RetUtil<UserDO> deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return RetUtil.ok();
    }

    /**
     * 查询单个用户
     */

    @GetMapping(value = "/users/{id}")
    public RetUtil<UserDO> getUserById(@PathVariable Integer id){
        UserDO userDO=userService.getUserId(id);
        return RetUtil.ok(userDO);
    }
}
