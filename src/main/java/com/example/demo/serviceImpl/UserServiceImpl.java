package com.example.demo.serviceImpl;

import com.example.demo.dao.PersonMapper;
import com.example.demo.pojo.User;
import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihu
 * @since 2019-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PersonMapper personMapper;

    @Override
    @Transactional
    public void getAll() {
        System.out.println(userMapper.selectById(1));
        //System.out.println(personMapper.selectById(2));
    }
}
