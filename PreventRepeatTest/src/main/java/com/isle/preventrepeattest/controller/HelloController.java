package com.isle.preventrepeattest.controller;

import com.isle.preventrepeattest.model.User;
import com.isle.preventrepeattest.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @PostMapping
    public String hello(@RequestBody User user) {
        LOGGER.info("user: {}", user);
        return helloService.hello(user);
    }

}
