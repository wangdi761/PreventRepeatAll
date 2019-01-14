package com.isle.preventrepeat.config;

import com.isle.preventrepeat.handler.PreventRepeatHandler;
import com.isle.preventrepeat.handler.RepeatResultHandler;
import com.isle.preventrepeat.handler.impl.DefaultRepeatResultHandler;
import com.isle.preventrepeat.handler.impl.RedisPreventRepeatHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.isle.preventrepeat")
public class PreventRepeatConfig {

    @Bean
    @ConditionalOnMissingBean
    public RepeatResultHandler repeatResultHandler() {
        return new DefaultRepeatResultHandler();
    }

    @Bean
    @ConditionalOnMissingBean
    public PreventRepeatHandler preventRepeatHandler() {
        return new RedisPreventRepeatHandler();
    }

}
