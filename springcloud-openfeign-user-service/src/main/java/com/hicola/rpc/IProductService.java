package com.hicola.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程调用接口-产品服务接口定义
 * Tips:假如在user-service服务里，想要调用product-service服务，则需要在这里定义接口方法，把product-service的接口暴露在这里，允许user-service调用
 * 相当于两个服务在这里订盟约、立规矩
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/27
 * @
 */
@FeignClient(value = "product-service") //这里的value值是指product-service服务里application.yml里配置的spring.application.name的值（即将要调用的服务名称）
public interface IProductService {
    /**
     * 根据ID获取产品信息，无反馈值void
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/product-api/findProductById", method = RequestMethod.POST)
    Object findProductById(@RequestParam("productId") String productId);

}
