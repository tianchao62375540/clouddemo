package com.consume.client;

import com.consume.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: tianchao
 * @Date: 2019/10/2 19:24
 * @Description:
 */
@FeignClient(value = "user-server",fallback = UserClientImpl.class)
public interface UserClient {
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}
