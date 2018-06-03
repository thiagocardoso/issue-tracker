package com.thiagocardoso.issuetracker.controller;


import com.thiagocardoso.issuetracker.document.User;
import com.thiagocardoso.issuetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository repository;

    public Flux<User> get() {
        return repository.findAll();
    }
}
