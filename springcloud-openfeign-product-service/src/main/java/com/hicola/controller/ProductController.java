package com.hicola.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品服务，被调用端，用户服务调用产品服务
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/26
 * @
 */
@RestController
@RequestMapping(value = "/product-api")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "/findProductById", method = RequestMethod.POST)
    public void findProductById(String productId) {
        logger.info("findProducts successfully by {}", productId);
    }
}
