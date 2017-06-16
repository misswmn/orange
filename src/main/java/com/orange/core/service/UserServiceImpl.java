/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.service;

import com.orange.core.dao.UserMapper;
import com.orange.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/2/7
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void delete(String id) {
        userMapper.deleteByPrimaryKey(Long.parseLong(id));
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }


}
