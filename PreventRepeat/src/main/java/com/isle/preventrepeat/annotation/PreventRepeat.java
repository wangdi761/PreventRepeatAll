package com.isle.preventrepeat.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PreventRepeat {

    /**
     * 防重前缀
     */
    String prefix();

    /**
     * key 成员变量属性
     */
    String keyFieldName();

}
