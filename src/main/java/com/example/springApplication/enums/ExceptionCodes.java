package com.example.springApplication.enums;

public enum ExceptionCodes {

    STUDENT_NOT_FOUND_EXCEPTION(100),
    VALIDATION_EXCEPTION(101);

    private int code;

    ExceptionCodes(int i) {
        code = i;
    }

    public int getCode() {
        return code;
    }

}
