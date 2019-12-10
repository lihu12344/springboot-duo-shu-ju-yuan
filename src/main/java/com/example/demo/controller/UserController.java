package com.example.demo.controller;


import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-12-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public String save(){
        for (int i=0;i<10;i++){
            User user=new User();
            user.setName("瓜田李下 "+i);
            user.setAge(i%5+10);

            userMapper.insert(user);
        }

        return "success";
    }

    @RequestMapping("/get")
    public String get(){
        userService.getAll();

        return "success";
    }
}