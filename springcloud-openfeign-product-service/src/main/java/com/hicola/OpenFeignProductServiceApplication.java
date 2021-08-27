package com.hicola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 产品服务-openFeign（[用户服务]会调用[产品服务]）
 * <p>
 * 在启动类上添加注解@EnableDiscoveryClient 或@EnableEurekaClient,可以让注册中心发现本服务
 * 两者共同点：都可以让注册中心能够发现、扫描到被注解的服务
 * 两者不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心，如：Zookeeper、Consul（Eureka 2.0闭源之后，Consul慢慢会成为主流）
 * <p>
 * Tips: 自Spring Cloud Edgware开始，@EnableDiscoveryClient 或@EnableEurekaClient 可省略。只需在pom.xml里加上相关依赖，并进行相应yml配置，即可将微服务注册到服务发现组件上
 */
@SpringBootApplication
/*@EnableDiscoveryClient*/
@EnableEurekaClient//开启注册服务发现，让注册中心能够发现、扫描到该服务
@EnableFeignClients //开启openFeign
public class OpenFeignProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignProductServiceApplication.class, args);
    }
}
