package com.hicola.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/30
 * @
 */
@Configuration
public class BeanConfiguration {
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
