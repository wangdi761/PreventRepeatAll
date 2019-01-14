package com.isle.preventrepeattest.handler;

import com.isle.preventrepeat.handler.RepeatResultHandler;
import org.springframework.stereotype.Component;

@Component
public class TestRepeatResultHandler implements RepeatResultHandler {
    @Override
    public Object repeatResult(String prefix, String key, Object[] args) {
        return prefix + key + "error";
    }
}
