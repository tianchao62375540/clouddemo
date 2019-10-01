package com.consume.web;

import com.consume.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: tianchao
 * @Date: 2019/10/1 22:26
 * @Description:
 */
@RestController
@RequestMapping("consumer")
public class ConsumeController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
        //地址寫死 是不行的 UserService只有一台 不符合高可用
        String url = "http://localhost:8081/user/"+id;
        User user = restTemplate.getForObject(url,User.class);
        return user;
    }

}
