package com.hicola.util;

import java.util.List;

/**
 * DESC: 处理响应消息工具类
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/27
 * @
 */
public class ResponseUtils {

    /**
     * 响应消息处理
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RequestMessage<T> response(String code, String msg, T data) {
        RequestMessage<T> message = new RequestMessage<>();
        message.setCode(code);
        if (null == msg || "".equals(msg)) {
            message.setMessage("No result message");
        } else {
            message.setMessage(msg);
        }
        message.setData(data);
        return message;
    }

    /**
     * 响应成功
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> RequestMessage<T> responseSuccessObject(T object) {
        return response(RequestMessage.SUCCESS_CODE, RequestMessage.SUCCESS_MSG, object);
    }

    public static <T> RequestMessage<List<T>> responseSuccessList(List<T> objectList) {
        return response(RequestMessage.SUCCESS_CODE, RequestMessage.SUCCESS_MSG, objectList);
    }

    /**
     * @param msg          自定义错误信息
     * @param exceptionMsg 当发生错误时，此时传入异常信息，如e.getMessage()
     * @param <T>
     * @return
     */
    public static <T> RequestMessage<T> responseFailed(String msg, String exceptionMsg) {
        RequestMessage<T> message = response(RequestMessage.ERROR_CODE, msg, null);
        message.setExceptionMsg(exceptionMsg);
        return message;
    }
}
