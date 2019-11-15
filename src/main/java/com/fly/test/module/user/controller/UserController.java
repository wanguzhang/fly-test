package com.fly.test.module.user.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.fly.test.common.util.RetUtil;
import com.fly.test.common.util.exception.BusinessException;
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


    /**
     * 模拟一个异常显示,业务逻辑，用于演示怎么写检查异常单测
     */
    @GetMapping(value = "/users/exception/{id}")
    public RetUtil throwException(@PathVariable Integer id) throws BusinessException {
        // 花钱超过这个数，报错
        int money=1111;

        if(id>money){
            throw new BusinessException("双 11 剁手都不够",40001);
        }
        return RetUtil.ok();
    }
    
    /**
     * 在 controller 调用静态方法示例展示
     */
    @GetMapping(value = "/users/static-method/{id}")
    public RetUtil<UserDO> staticMethod(@PathVariable Integer id){
        String s = HttpUtil.get("http://localhost:8080/" + id);
        UserDO userDO = JSON.parseObject(s, UserDO.class);
        return RetUtil.ok(userDO);
    }

    /**
     * 展示 无返回值的示例
     */
    @GetMapping(value = "/users/no-return")
    public RetUtil noReturn(){
        userService.returnVoid();
        return RetUtil.ok();
    }
}
