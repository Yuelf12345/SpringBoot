package com.example.yue.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 拦截所有异常
public class GlobalException {

    Logger log = LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler({Exception.class})
    public Result<String> handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        log.error("[全局异常处理]", e);
        return Result.fail(500, "error");
    }
}
