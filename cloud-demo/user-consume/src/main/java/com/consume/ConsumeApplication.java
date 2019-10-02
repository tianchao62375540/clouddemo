package com.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: tianchao
 * @Date: 2019/10/1 22:21
 * @Description:
 */
//熔断   熔断+eureka+springbootApplicaton == springcloudApplication
@EnableCircuitBreaker
//消费者和提供者都是客户端
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class,args);
    }

    //內置攔截器 攔截請求
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
