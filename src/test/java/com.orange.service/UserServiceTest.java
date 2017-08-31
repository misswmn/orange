
package com.orange.service;

import com.orange.core.config.WebAppConfig;
import com.orange.core.domain.User;
import com.orange.core.service.RoleService;
import com.orange.core.service.UserService;
import com.orange.core.spring.bean.ClientDTO;
import com.orange.core.spring.bean.Role;
import com.orange.core.spring.bean.Sample;
import com.orange.core.spring.bean.Simple;
import com.orange.core.spring.bean.UserPassword;
import com.orange.core.util.JedisClient;
import com.orange.core.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
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
    @Inject
    private RoleService roleService;
    @Inject
    private JedisClient jedisClient;

    @Test
    public void testDeleteById() {
        userService.delete("11");
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
        dto.setRedirectUris(Arrays.asList("123", "124"));
        userService.saveOne(dto);
    }

    @Test
    public void testChangePwd() {
        UserPassword user = new UserPassword();
        user.setNewPassword("1");
        user.setConfirmPassword(null);
        userService.changePwd(user);
    }

    @Test
    public void testSaveOne() {
        Simple simple = new Simple();
        userService.saveOne(simple);
    }

    @Test
    public void testSaveRole() {
        Role role = new Role();
        role.setName("管理员");
        role.setId(50);
        roleService.saveOne(role);
    }

    @Test
    public void testSaveSample() {
        Sample sample = new Sample();
        sample.setCount(8);
        sample.setEnabled(true);
        userService.save(sample);
    }

    @Test
    public void testJedis(){
        jedisClient.set("product", "FFFFFFUCK");
    }
}


