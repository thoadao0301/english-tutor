package com.englishtutor.controller;

import com.englishtutor.common.ResponseObject;
import com.englishtutor.controller.interfaces.IUserController;
import com.englishtutor.dtos.request.user.*;
import com.englishtutor.dtos.response.user.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class UserController implements IUserController {
    @Override
    public ResponseEntity<ResponseObject<CheckEmailIfExistResponse>> checkEmailIfExist(CheckEmailIfExistRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject<RegisterUserResponse>> register(RegisterUserRequest request) {
        return null;
    }

    @Override
    @RolesAllowed("ef_user")
    public ResponseEntity<ResponseObject<UpdateUserResponse>> update(UpdateUserRequest request) {
        return null;
    }

    @Override
    @RolesAllowed("ef_user")
    public ResponseEntity<ResponseObject<UpdateAvatarResponse>> updateAvatar(UpdateAvatarRequest request) {
        return null;
    }

    @Override
    @RolesAllowed("ef_user")
    public ResponseEntity<ResponseObject<GetUserInfoResponse>> getInfo(GetUserInfoRequest request) {
        return null;
    }

    @Override
    @RolesAllowed("ef_admin")
    public ResponseEntity<ResponseObject<GetUserListResponse>> getUserList(GetUserListRequest request) {
        return null;
    }
}
