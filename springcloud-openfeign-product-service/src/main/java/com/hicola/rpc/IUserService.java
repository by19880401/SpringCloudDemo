package com.hicola.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/27
 * @
 */
@FeignClient(value = "user-service")
public interface IUserService {
    /**
     * 根据ID查询用户信息，有返回值
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user-api/findUserInfo", method = RequestMethod.POST)
    Object findUserInfo(@RequestParam("userId") String userId);
}
