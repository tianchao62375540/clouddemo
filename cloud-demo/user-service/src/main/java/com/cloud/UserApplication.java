package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auther: tianchao
 * @Date: 2019/10/1 22:04
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages={"com.cloud.user.mapper"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
