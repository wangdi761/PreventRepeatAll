package com.isle.preventrepeattest.mapper;

import com.isle.preventrepeattest.model.PreventRepeat;
import com.isle.preventrepeattest.model.PreventRepeatExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface PreventRepeatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prevent_repeat
     *
     * @mbg.generated
     */
    int deleteByExample(PreventRepeatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prevent_repeat
     *
     * @mbg.generated
     */
    int insert(PreventRepeat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prevent_repeat
     *
     * @mbg.generated
     */
    int insertSelective(PreventRepeat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prevent_repeat
     *
     * @mbg.generated
     */
    List<PreventRepeat> selectByExample(PreventRepeatExample example);
}