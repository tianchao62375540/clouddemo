package com.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: tianchao
 * @Date: 2019/10/8 22:05
 * @Description:
 */
@EnableZuulProxy
@SpringBootApplication
public class GeteawayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeteawayApplication.class,args);
    }
}
