package com.orange.core.dao;

import com.orange.core.domain.User;

import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/2/7
 * @description
 */

public interface UserMapper {
    List<User> findAll();
    int deleteByPrimaryKey(Long id);
    User login(String username, String password);
    int updateLastLoginTime(User user);
}