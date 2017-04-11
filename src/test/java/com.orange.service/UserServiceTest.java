package com.orange.service;

import com.orange.core.app.WebAppConfig;
import com.orange.core.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

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
}
