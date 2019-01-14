package com.isle.preventrepeat.handler;

public interface PreventRepeatHandler {

    /**
     * 设置key
     * @param prefix
     * @param key
     * @return
     */
    boolean setIfAbsent(String prefix, String key);

    /**
     * 删除key
     * @param prefix
     * @param key
     */
    void delete(String prefix, String key);

}
