package com.hicola.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 产品服务，被调用端，用户服务调用产品服务
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/26
 * @
 */
@RestController
@RequestMapping(value = "/productApi")
public class ProductAPIController {

    @RequestMapping(value = "/findAllProducts", method = RequestMethod.POST)
    public void findProducts(String productId) {
        System.out.println("findProducts successfully" + productId);
    }
}
