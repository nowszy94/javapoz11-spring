package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sda.javapoz11.hellospring.hellospring.service.MyService;
import com.sda.javapoz11.hellospring.hellospring.service.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {

//    @Qualifier("bigNumbersGenerator") // mowi springowi jaka ma byc nazwa wstrzykiwanego beana
    @Autowired // mowi springowi zeby w to pole wstrzyknac obiekt (bean) - autowired stosowac tylko na konstruktorze
    private RandomGenerator randomGenerator;

    @Autowired
    private List<RandomGenerator> randomGeneratorList;

    @Autowired
    private MyService myService;

    @Autowired
    private MyService myService2;

    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello.html");
        modelAndView.addObject("message", "Ala ma kota");
        return modelAndView;
    }

    @GetMapping("/hello/{id}")
    public ModelAndView hellasfo(@PathVariable("id") Integer id) {
        if (id.equals(2)) {
            throw new ProductNotFoundException();
        }
        ModelAndView modelAndView = new ModelAndView("hello.html");
        modelAndView.addObject("message", "Ala ma kota");
        return modelAndView;
    }

    public static class ProductNotFoundException extends RuntimeException {}
}
