package com.hicola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户服务-openFeign（[用户服务]会调用[产品服务]）
 */
@SpringBootApplication
@EnableDiscoveryClient //开启注册服务发现，让注册中心能够发现、扫描到该服务
/*@EnableEurekaClient*/
@EnableFeignClients//开启openFeign，只要你有别人要调用的接口，就要开启openFeign
public class OpenFeignUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignUserServiceApplication.class, args);
    }
}
