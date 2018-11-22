package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sda.javapoz11.hellospring.hellospring.service.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//    @Qualifier("bigNumbersGenerator") // mowi springowi jaka ma byc nazwa wstrzykiwanego beana
    @Autowired // mowi springowi zeby w to pole wstrzyknac obiekt (bean)
    private RandomGenerator randomGenerator;

    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello.html");
        modelAndView.addObject("message", "Ala ma kota");
        return modelAndView;
    }
}
