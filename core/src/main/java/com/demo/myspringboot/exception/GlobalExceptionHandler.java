package com.demo.myspringboot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @className GlobalExceptionHandler
 * @Author xiaolu
 * @date 2021/1/26 10:08
 */
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value= Exception.class)
    public Map<String, Object> myException(Exception ex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 500);
        map.put("msg", "出错了。");
        return map;
    }
}