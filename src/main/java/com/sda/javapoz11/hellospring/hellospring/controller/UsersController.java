package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sda.javapoz11.hellospring.hellospring.entity.User;
import com.sda.javapoz11.hellospring.hellospring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users") // prefiks wszystkich mappingow
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<User> users(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        return usersService.findAll();
    }

    @GetMapping(params = "lastName")
    public List<User> usersByLastName(@RequestParam("lastName") String lastName) {
        return usersService.findByLastName(lastName);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return usersService.findById(id);
    }
}
