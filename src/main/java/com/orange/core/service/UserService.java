package com.orange.core.service;

import com.orange.core.domain.User;
import com.orange.core.spring.bean.ClientDTO;
import com.orange.core.spring.bean.Sample;
import com.orange.core.spring.bean.Simple;
import com.orange.core.spring.bean.UserPassword;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/2/7
 * @description
 */
@Validated
public interface UserService {

    void delete(@NotEmpty(message = "{user.service.delete.id}") String id);

    List<User> findAll();

    void saveOne(@Valid ClientDTO clientDTO);

    void saveOne(@Valid Simple simple);

    void changePwd(@NotNull(message = "{common.param.illegal}") @Valid UserPassword user);

    void save(@NotNull(message = "{common.param.illegal}") @Valid Sample sample);

    User login(@NotNull(message = "{common.param.illegal}") String username,
               @NotNull(message = "{common.param.illegal}") String password);

    void updateLastLoginTime(User user);
}
