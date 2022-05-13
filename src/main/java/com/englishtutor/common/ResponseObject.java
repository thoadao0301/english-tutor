package com.englishtutor.common;

import lombok.Data;

@Data
public class ResponseObject<T>{
    private int statusCode;
    private String message;
    private T data;
}
