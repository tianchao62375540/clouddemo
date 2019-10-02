package com.consume.web;

import com.consume.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: tianchao
 * @Date: 2019/10/1 22:26
 * @Description:
 */
@RestController
@RequestMapping("consumer")
@Slf4j
@DefaultProperties(defaultFallback = "queryByIdFallbackAllMethod")
public class ConsumeController {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 发现客户端
     */
    //@Autowired
    //private DiscoveryClient discoveryClient;
    //@Autowired
    //private RibbonLoadBalancerClient client;

    /*@GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User queryById(@PathVariable("id") Long id){
        //地址寫死 是不行的 UserService只有一台 不符合高可用
        //String url = "http://localhost:8081/user/"+id;
        //User user = restTemplate.getForObject(url,User.class);
        //根据服务id获取实例 （可能多个）
        //List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
        //輪訓
        //ServiceInstance instance = client.choose("user-server");
        //ServiceInstance instance = instances.get(0);
        //String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
        String url = "http://user-server/user/"+id;
        log.debug("调用url:"+url);
        final User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/
    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //失败方法 单个设置
    //@HystrixCommand(fallbackMethod = "queryByIdFallbackMethod")
    @HystrixCommand/*(commandProperties = {
            //自定义超时时长
         @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
    public String queryById(@PathVariable("id") Long id){
        String url = "http://user-server/user/"+id;
        log.debug("调用url:"+url);
        String user = restTemplate.getForObject(url, String.class);
        return user;
    }

    /**
     * 失败处理  返回值和参数列表完全一样
     * @param id
     * @return
     */
    public String queryByIdFallbackMethod(Long id){
        return "服务器太拥挤了.....";
    }
    public String queryByIdFallbackAllMethod(){
        return "服务器十分拥挤........";
    }

}
