package com.example.springApplication.enums;

public enum ExceptionCodes {

    STUDENT_NOT_FOUND_EXCEPTION(1000);

    private int code;

    ExceptionCodes(int i) {
        code = i;
    }

    public int getCode() {
        return code;
    }

}
