package com.hicola.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hicola.rpc.IProductService;
import com.hicola.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping(value = "/findUserInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object findUserInfo(@RequestParam("userId") String userId) {
        logger.info("UserController::findUserInfo, userId: {}", userId);
        Map<String, Object> result = new HashMap<>();
        result.put("ResultCode", "00000");
        result.put("ResultMsg", "success");
        return result;
    }

    @RequestMapping(value = "/findUserInfoAsJson", method = RequestMethod.POST)
    public Object findUserInfoAsJson(@RequestParam("userId") String userId) throws JsonProcessingException {
        try {
            logger.info("UserController::findUserInfoAsJson, userId: {}", userId);
            List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
            return ResponseUtils.responseSuccessObject(list);
        } catch (Exception e) {
            logger.warn("查询用户信息失败", e);
            return ResponseUtils.responseFailed("查询用户信息失败", e.getMessage());
        }
    }
}
