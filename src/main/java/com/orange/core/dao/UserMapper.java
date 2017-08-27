package com.orange.core.dao;

import com.orange.core.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    @Update("UPDATE user SET status = 4 WHERE id=#{id}")
    int deleteByPrimaryKey(Long id);

    @Select("SELECT * FROM user")
    @ResultType(User.class)
    List<User> findAll();

    @Select("SELECT * FROM user WHERE username=#{user} AND password=#{pwd}")
    User login(@Param("user") String username, @Param("pwd") String password);
}