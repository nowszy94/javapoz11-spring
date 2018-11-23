package com.sda.javapoz11.hellospring.hellospring.service;


import com.sda.javapoz11.hellospring.hellospring.entity.User;
import com.sda.javapoz11.hellospring.hellospring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Profile("!prod")
@Service
public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User findById(long id) {
        return usersRepository.findById(id)
                .orElse(null);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        usersRepository.findAll()
                .forEach(e -> users.add(e));
        return users;
    }

    public List<User> findByLastName(String lastName) {
        return usersRepository.findByLastName(lastName);
    }

    @PostConstruct
    private void init() {
        usersRepository.save(User.builder().firstName("Szymon").lastName("Nowak").age(24).build());
        usersRepository.save(User.builder().firstName("Jan").lastName("Kowalski").age(40).build());
        usersRepository.save(User.builder().firstName("Anna").lastName("Wisniewska").age(30).build());
        usersRepository.save(User.builder().firstName("Krzysztof").lastName("Nowak").age(31).build());
    }
}
