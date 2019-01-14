package com.isle.preventrepeat.annotation;

import com.isle.preventrepeat.config.PreventRepeatConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Import(PreventRepeatConfig.class)
public @interface EnablePreventRepeat {
}
