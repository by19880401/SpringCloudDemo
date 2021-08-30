package com.hicola.util;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/27
 * @
 */
public class RequestMessage<T> {

    public static String SUCCESS_CODE = "200";

    public static String SUCCESS_MSG = "success";

    public static String ERROR_CODE = "500";

    public static String ERROR_MSG = "error";


    private String code;
    private String message;
    private String exceptionMsg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
