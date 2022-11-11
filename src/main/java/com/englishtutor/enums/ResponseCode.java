package com.englishtutor.enums;

public enum ResponseCode {
    // Common response code
    SUCCESS(0, "Success"),
    FAIL(1, "Fail"),
    COMMON_ERROR(2, "Common error"),
    INVALID_PARAMS(3, "Invalid parameters"),
    ;

    private int code;
    private String message;
    ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
