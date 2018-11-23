package com.sda.javapoz11.hellospring.hellospring.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Scope("prototype")
@Component
public class MyService {
    private Integer value;

    public MyService() {
        Random random = new Random();
        this.value = random.nextInt(10);
    }

    public Integer getValue() {
        return value;
    }
}
