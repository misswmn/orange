package com.orange.core.dao;

import com.orange.core.domain.User;
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
    @Update("UPDATE USER SET status='01' WHERE id=#{id}")
    int deleteByPrimaryKey(Long id);

    @Select("SELECT * FROM user")
    List<User> findAll();
}