package com.cloud.user.service;

import com.cloud.user.pojo.User;

/**
 * @Auther: tianchao
 * @Date: 2019/10/1 13:58
 * @Description:
 */
public interface UserService {
    User queryById(Long id);
    void insertUser(User user);
}
