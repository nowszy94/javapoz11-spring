package com.sda.javapoz11.hellospring.hellospring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ProductErrorHandler {

    @ExceptionHandler(HelloController.ProductNotFoundException.class)
    public ModelAndView productNotFound() {
        return new ModelAndView("product-not-found.html");
    }
}
