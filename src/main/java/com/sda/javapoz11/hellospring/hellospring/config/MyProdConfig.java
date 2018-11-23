package com.sda.javapoz11.hellospring.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class MyProdConfig {

    @Bean
    public String abc() {
        return "asf";
    }

    @Bean
    public String abcdef() {
        return "asf";
    }
}
