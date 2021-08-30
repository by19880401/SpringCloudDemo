package com.hicola.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/30
 * @
 */
public enum ResponseConvertUtil {
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(ResponseConvertUtil.class);

    /**
     * 将Object对象数据转换成相应的具体对象数据
     *
     * @param bean
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T convertValue(Object bean, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(bean, clazz);
        } catch (Exception e) {
            logger.warn("Convert response error.", e.getMessage());
            return null;
        }
    }
}
