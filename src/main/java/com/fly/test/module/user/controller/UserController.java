package com.fly.test.module.user.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.fly.test.common.util.RetUtil;
import com.fly.test.module.user.entity.UploadFileDTO;
import com.fly.test.module.user.entity.UserDO;
import com.fly.test.module.user.entity.UserDTO;
import com.fly.test.module.user.entity.vo.UploadVO;
import com.fly.test.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

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

    @PostMapping(value = "/file")
    public RetUtil<UploadVO> uploadFile(UploadFileDTO uploadFileDTO) throws IOException {
        MultipartFile file = uploadFileDTO.getFile();
        byte[] bytes = file.getBytes();
        String s = new String(bytes, StandardCharsets.UTF_8);
        UploadVO build = UploadVO.builder().content(s).type(uploadFileDTO.getType()).build();
        return RetUtil.ok(build);
    }
}
