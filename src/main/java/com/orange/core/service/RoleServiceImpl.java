package com.orange.core.service;

import com.orange.core.spring.bean.Role;
import org.springframework.stereotype.Service;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/26
 * @description
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public void saveOne(Role role) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }
}
