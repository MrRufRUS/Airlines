package com.ruftech.course_work.db_data;

public class Income {
    private final String value1;
    private final String value2;
    private final String value3;


    public Income(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public String getValue3() {
        return value3;
    }
}
