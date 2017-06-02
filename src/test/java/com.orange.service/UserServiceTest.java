package com.orange.service;

import com.orange.core.app.WebAppConfig;
import com.orange.core.domain.User;
import com.orange.core.service.UserService;
import com.orange.core.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/2/7
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration
public class UserServiceTest {
    @Inject
    private UserService userService;

    @Test
    public void testDeleteById() {
        userService.delete(4);
    }

    @Test
    public void testFindAll() {
        List<User> userList = userService.findAll();
        System.out.println(JsonUtils.objectToJson(userList));
    }
}
