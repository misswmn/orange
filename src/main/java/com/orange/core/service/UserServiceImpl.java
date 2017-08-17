/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.service;

import com.orange.core.dao.UserMapper;
import com.orange.core.domain.User;
import com.orange.core.spring.bean.ClientDTO;
import com.orange.core.spring.bean.Sample;
import com.orange.core.spring.bean.Simple;
import com.orange.core.spring.bean.UserPassword;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/2/7
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserMapper userMapper;

    @Override
    public void delete(String id) {
        userMapper.deleteByPrimaryKey(Long.parseLong(id));
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void saveOne(ClientDTO clientDTO) {
        System.out.println("+++++++++++++++++++++");
    }

    @Override
    public void saveOne(Simple simple) {
        System.out.println("+++++++++++++++++++++");
    }

    @Override
    public void changePwd(UserPassword user) {
        System.out.println("+++++++++++++++++++++");
    }

    @Override
    public void save(Sample sample) {
        System.out.println("+++++++++++++++++++++");
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public int updateLastLoginTime(User user) {
        return userMapper.updateLastLoginTime(user);
    }
}
