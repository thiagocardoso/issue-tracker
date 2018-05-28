package com.thiagocardoso.issuetracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/testcontroller")
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Mono<String> test() {
        return Mono.just("Test");
    }
}
