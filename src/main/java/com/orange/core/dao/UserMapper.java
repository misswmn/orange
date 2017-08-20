package com.orange.core.dao;

import com.orange.core.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/2/7
 * @description
 */
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    List<User> findAll();
}