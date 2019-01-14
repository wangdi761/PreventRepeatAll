package com.isle.preventrepeat.handler;

/**
 * 重复请求返回结果Handler
 */
public interface RepeatResultHandler {

    Object repeatResult(String prefix, String key, Object[] args);

}
