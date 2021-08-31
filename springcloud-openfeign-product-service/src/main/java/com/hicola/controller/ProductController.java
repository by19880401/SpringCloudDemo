package com.hicola.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hicola.rpc.IUserService;
import com.hicola.util.RequestMessage;
import com.hicola.util.ResponseConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final IUserService userService;

    private final ObjectMapper objectMapper;//方式二，注入jackson的ObjectMapper

    @Autowired
    public ProductController(IUserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(value = "/findProductById", method = RequestMethod.POST)
    public void findProductById(String productId) {
        logger.info("ProductController::findProductById, productId:{}", productId);
    }

    @RequestMapping(value = "/findUserInfo", method = RequestMethod.POST)
    public Object findUserInfo() {
        String userId = "999999999";
        logger.info("ProductController::findUserInfo, userId:{}", userId);
        Object resObj = userService.findUserInfo(userId);
        logger.info("Result:{}", resObj.toString());
        return resObj;
    }

    /**
     * 通过openFeign接口调用返回响应消息时，一般会返回Object类型的json对象
     * 此时在接口调用端（接受端）需要转换一下
     * 目前我了解到的有下面两种方式：方式一和方式二
     *
     * @return
     */
    @RequestMapping(value = "/findUserInfoAsJson1", method = RequestMethod.POST)
    public Object findUserInfoAsJson1() {
        String userId = "999999999";
        logger.info("ProductController::findUserInfoAsJson, userId:{}", userId);
        Object resObj = userService.findUserInfoAsJsonData1(userId);
        RequestMessage msg = ResponseConvertUtil.INSTANCE.convertValue(resObj, RequestMessage.class);//方式一
        logger.info("Result:{}", msg.toString());
        return resObj;
    }

    @RequestMapping(value = "/findUserInfoAsJson2", method = RequestMethod.POST)
    public Object findUserInfoAsJson2() {
        RequestMessage msg = null;
        try {
            String userId = "999999999";
            logger.info("ProductController::findUserInfoAsJson, userId:{}", userId);
            String userInfoRes = userService.findUserInfoAsJsonData2(userId);
            /*msg = objectMapper.convertValue(userInfoRes,RequestMessage.class);*/
            msg = objectMapper.readValue(userInfoRes, new TypeReference<RequestMessage>() {});//方式二
        } catch (JsonProcessingException e) {
            logger.warn("ProductController::findUserInfoAsJson2 Error", e.getMessage());
        }
        logger.info("Result:{}", msg.toString());
        return msg;
    }

}
