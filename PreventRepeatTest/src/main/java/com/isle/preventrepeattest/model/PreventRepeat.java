package com.isle.preventrepeattest.model;

public class PreventRepeat {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prevent_repeat.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column prevent_repeat.val
     *
     * @mbg.generated
     */
    private String val;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prevent_repeat
     *
     * @mbg.generated
     */
    public PreventRepeat(Integer id, String val) {
        this.id = id;
        this.val = val;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table prevent_repeat
     *
     * @mbg.generated
     */
    public PreventRepeat() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prevent_repeat.id
     *
     * @return the value of prevent_repeat.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prevent_repeat.id
     *
     * @param id the value for prevent_repeat.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column prevent_repeat.val
     *
     * @return the value of prevent_repeat.val
     *
     * @mbg.generated
     */
    public String getVal() {
        return val;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column prevent_repeat.val
     *
     * @param val the value for prevent_repeat.val
     *
     * @mbg.generated
     */
    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }
}