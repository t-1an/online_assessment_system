package com.xt.assessment.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error("exception handler: ", e);
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("msg", e.getMessage());
        return map;
    }

    @ExceptionHandler(value = IllegalAccessException.class)
    @ResponseBody
    private Map<String, Object> tokenExpired(Exception e) {
        e.printStackTrace();
        log.warn("token exception: ", e);
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", -1);
        map.put("msg", e.getMessage());
        return map;
    }
}
