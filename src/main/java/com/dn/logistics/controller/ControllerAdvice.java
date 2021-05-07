package com.dn.logistics.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = Throwable.class)
    private String handleOtherException(HttpServletRequest request, Throwable cause) {
        System.out.println("System occurs error cause: " + cause.getMessage());
        return "error";
    }
}
