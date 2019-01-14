package com.isle.preventrepeattest.service.impl;

import com.isle.preventrepeat.annotation.PreventRepeat;
import com.isle.preventrepeattest.model.User;
import com.isle.preventrepeattest.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @PreventRepeat(prefix = "user", keyFieldName = "id")
    public String hello(User user) {
        return user.toString();
    }
}
