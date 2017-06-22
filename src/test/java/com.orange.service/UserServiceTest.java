
package com.orange.service;

import com.orange.core.config.WebAppConfig;
import com.orange.core.domain.User;
import com.orange.core.service.UserService;
import com.orange.core.spring.bean.ClientDTO;
import com.orange.core.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
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
        userService.delete("");
    }

    @Test
    public void testFindAll() {
        List<User> userList = userService.findAll();
        System.out.println(JsonUtils.objectToJson(userList));
    }

    @Test
    public void testSave() {
        ClientDTO dto = new ClientDTO();
        dto.setGrantTypes(Arrays.asList(new String[]{"age", "name", "email", "auth_code"}));
        dto.setRedirectUris(new ArrayList<>());
        userService.saveOne(dto);
    }
}


