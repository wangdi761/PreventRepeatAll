package com.isle.preventrepeattest.handler;

import com.isle.preventrepeat.handler.PreventRepeatHandler;
import com.isle.preventrepeattest.mapper.PreventRepeatMapper;
import com.isle.preventrepeattest.model.PreventRepeat;
import com.isle.preventrepeattest.model.PreventRepeatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MysqlPreventRepeatHandler implements PreventRepeatHandler {

    @Autowired
    private PreventRepeatMapper preventRepeatMapper;

    @Override
    public boolean setIfAbsent(String prefix, String key) {
        try {
            PreventRepeat preventRepeat = new PreventRepeat();
            preventRepeat.setVal(prefix + key);
            preventRepeatMapper.insert(preventRepeat);
        } catch (RuntimeException e) {
            String msg = e.getMessage();
            if (StringUtils.hasText(msg) && msg.contains("idx_val")) {
                return false;
            }
            throw e;
        }
        return true;
    }

    @Override
    public void delete(String prefix, String key) {
        PreventRepeatExample example = new PreventRepeatExample();
        example.createCriteria().andValEqualTo(prefix + key);
        preventRepeatMapper.deleteByExample(example);
    }
}
