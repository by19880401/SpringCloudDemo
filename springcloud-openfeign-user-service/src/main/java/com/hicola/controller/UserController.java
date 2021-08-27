package com.hicola.controller;

import com.hicola.rpc.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/27
 * @
 */
@RestController
@RequestMapping(value = "/user-api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final IProductService productService;

    @Autowired
    public UserController(IProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/findUserAndProductInfo", method = RequestMethod.POST)
    public void findUserAndProductInfo() {
        logger.info("UserController::findUserAndProductById");
        String productId = "123456";
        productService.findProductById(productId);
    }
}
