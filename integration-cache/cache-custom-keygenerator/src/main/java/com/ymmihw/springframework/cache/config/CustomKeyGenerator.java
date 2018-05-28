package com.ymmihw.springframework.cache.config;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

public class CustomKeyGenerator implements KeyGenerator {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public Object generate(Object target, Method method, Object... params) {
    String key = target.getClass().getSimpleName() + "_" + method.getName() + "_"
        + StringUtils.arrayToDelimitedString(params, "_");
    logger.info("generate key {}", key);
    return key;
  }
}
