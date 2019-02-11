package com.isle.preventrepeat.aspect;

import com.isle.preventrepeat.annotation.PreventRepeat;
import com.isle.preventrepeat.handler.PreventRepeatHandler;
import com.isle.preventrepeat.handler.RepeatResultHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Aspect
@Component
public class PreventRepeatAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreventRepeatAspect.class);

    @Autowired
    private PreventRepeatHandler preventRepeatHandler;

    @Autowired
    private RepeatResultHandler repeatResultHandler;

    @Pointcut("@annotation(com.isle.preventrepeat.annotation.PreventRepeat)")
    public void preventRepeat() {

    }

    @Around("preventRepeat()")
    public Object doInvoke(ProceedingJoinPoint pjp) throws Throwable {
        PreventRepeat preventRepeat = getPreventRepeat(pjp);

        String prefix = preventRepeat.prefix();
        String keyFieldName = preventRepeat.keyFieldName();
        Assert.hasText(prefix, "prefix don't have text");
        Assert.hasText(keyFieldName, "keyFieldName don't have text");

        String key = getKey(pjp, keyFieldName);
        Assert.hasText(key, "key don't have text");

        if (!preventRepeatHandler.setIfAbsent(prefix, key)) {
            LOGGER.warn("repeat request, prefix = {}, key = {}", prefix, key);
            return repeatResultHandler.repeatResult(prefix, key, pjp.getArgs());
        }
        try {
            return pjp.proceed();
        } finally {
            preventRepeatHandler.delete(prefix, key);
        }
    }

    /**
     * 封装获取 PreventRepeat 的具体实现
     * @param pjp 
     * @return
     * @throws NoSuchMethodException
     */
    private PreventRepeat getPreventRepeat(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        Object target = pjp.getTarget();
        String method = pjp.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) pjp.getSignature()).getMethod().getParameterTypes();
        Method m = target.getClass().getMethod(method, parameterTypes);
        return AnnotationUtils.findAnnotation(m, PreventRepeat.class);
    }

    /**
     * 获取key
     * @param pjp
     * @param keyFieldName
     * @return key
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private String getKey(ProceedingJoinPoint pjp, String keyFieldName) throws IllegalAccessException {
        Object[] args = pjp.getArgs();
        Assert.notEmpty(args, "method args not found");

        String key = null;
        for (Object arg : args) {
            Assert.notNull(arg, "arg is null");
            Class<?> argClass = arg.getClass();

            Field keyField;
            try {
                keyField = argClass.getDeclaredField(keyFieldName);
            } catch (NoSuchFieldException e) {
                continue;
            }
            keyField.setAccessible(true);

            Assert.isTrue(keyField.getType().equals(String.class), "keyField not a String");
            key = (String) keyField.get(arg);
            break;
        }
        return key;
    }

}
