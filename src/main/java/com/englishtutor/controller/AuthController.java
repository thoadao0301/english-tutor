package com.englishtutor.controller;

import com.englishtutor.common.ResponseObject;
import com.englishtutor.controller.interfaces.IAuthController;
import com.englishtutor.dtos.request.auth.ChangePasswordRequest;
import com.englishtutor.dtos.request.auth.LoginRequest;
import com.englishtutor.dtos.request.auth.LogoutRequest;
import com.englishtutor.dtos.response.auth.ChangePasswordResponse;
import com.englishtutor.dtos.response.auth.LoginResponse;
import com.englishtutor.dtos.response.auth.LogoutResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements IAuthController {
    @Override
    public ResponseEntity<ResponseObject<LoginResponse>> login(LoginRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject<LogoutResponse>> logout(LogoutRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject<ChangePasswordResponse>> changePassword(ChangePasswordRequest request) {
        return null;
    }
}
