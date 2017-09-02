package com.orange.core.util;

import com.orange.core.domain.User;
import com.orange.core.domain.user.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanUtil {
    public static <S, R> List<R> copy(List<S> src, Class<R> clazz) throws Exception {
        if (CollectionUtils.isEmpty(src)) {
            return null;
        }
        List<R> result = new ArrayList<>(src.size());
        for (S s : src) {
            R r = clazz.newInstance();
            BeanUtils.copyProperties(s, r);
            result.add(r);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        List<User> src = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setUsername("admin" + i);
            user.setPassword("admin" + i);
            src.add(user);
        }
        long start = System.currentTimeMillis();
//        List<UserDTO> result = copy(src, UserDTO.class);
//        System.out.println(JSON.toJSONString(result));

        List<UserDTO> r = new ArrayList<>(src.size());
        for (User user : src) {
            UserDTO u = new UserDTO();
            BeanUtils.copyProperties(user, u);
            r.add(u);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }
}
