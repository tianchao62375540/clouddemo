package com.consume.client;

import com.consume.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2019/10/2 20:49
 * @Description:
 */
//熔断业务逻辑
@Component
public class UserClientImpl implements UserClient {
    @Override
    public User queryById(Long id) {
        return new User().setName("未知用户。。。。");
    }
}
