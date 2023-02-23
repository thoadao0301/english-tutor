package com.thoa.englishTutor.controller;

import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.controller.interfaces.IAuthController;
import com.thoa.englishTutor.dtos.request.auth.ChangePasswordRequest;
import com.thoa.englishTutor.dtos.request.auth.LoginRequest;
import com.thoa.englishTutor.dtos.request.auth.LogoutRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements IAuthController {
    @Override
    public ResponseEntity<ResponseObject> login(LoginRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> logout(LogoutRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> changePassword(ChangePasswordRequest request) {
        return null;
    }
}
