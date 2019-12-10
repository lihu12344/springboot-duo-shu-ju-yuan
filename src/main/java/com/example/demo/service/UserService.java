package com.example.demo.service;

import com.example.demo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihu
 * @since 2019-12-10
 */
public interface UserService extends IService<User> {

    void getAll();
}
