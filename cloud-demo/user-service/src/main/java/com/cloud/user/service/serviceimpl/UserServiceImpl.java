package com.cloud.user.service.serviceimpl;

import com.cloud.user.mapper.UserMapper;
import com.cloud.user.pojo.User;
import com.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: tianchao
 * @Date: 2019/10/1 13:59
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    @Transactional
    public void insertUser(User user){
        userMapper.insert(user);
    }
}
