package com.englishtutor.common;


import com.englishtutor.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseObject<T>{
    private int statusCode;
    private String message;
    private T data;

    public ResponseObject(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = null;
    }

    public ResponseObject success(T data) {
        this.statusCode = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
        this.data = data;
        return this;
    }

    public ResponseObject success(){
        return success(null);
    }

    public ResponseObject fail(T data) {
        this.statusCode = ResponseCode.FAIL.getCode();
        this.message = ResponseCode.FAIL.getMessage();
        this.data = data;
        return this;
    }

    public ResponseObject fail(){
        return fail(null);
    }

    public ResponseObject common(T data) {
        this.statusCode = ResponseCode.COMMON_ERROR.getCode();
        this.message = ResponseCode.COMMON_ERROR.getMessage();
        this.data = data;
        return this;
    }

    public ResponseObject common(){
        return common(null);
    }

    public ResponseObject businessError(ResponseCode responseCode){
        this.statusCode = responseCode.getCode();
        this.message = responseCode.getMessage();
        return this;
    }
}
