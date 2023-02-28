package com.thoa.englishTutor.controller;

import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.controller.interfaces.IUserController;
import com.thoa.englishTutor.dtos.request.user.*;
import com.thoa.englishTutor.enums.UserRole;
import com.thoa.englishTutor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
public class UserController implements IUserController {
    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/checkEmailIfExist")
    public ResponseEntity<ResponseObject> checkEmailIfExist(String email) {
        return new ResponseEntity(userService.checkEmailIfExist(new CheckEmailIfExistRequest(email)), HttpStatus.OK);
    }

    @Override
    @PostMapping("/studentRegister")
    public ResponseEntity<ResponseObject> studentRegister(RegisterUserRequest request) {
        return new ResponseEntity<>(userService.register(request, UserRole.ROLE_STUDENT),HttpStatus.OK);
    }

    @Override
    @PutMapping("/update")
    @RolesAllowed("ef_user")
    public ResponseEntity<ResponseObject> update(UpdateUserRequest request) {
        return null;
    }

    @Override
    @PutMapping("/updateAvatar")
    @RolesAllowed("ef_user")
    public ResponseEntity<ResponseObject> updateAvatar(UpdateAvatarRequest request) {
        return null;
    }

    @Override
    @GetMapping("/getInfo")
    @RolesAllowed("ef_user")
    public ResponseEntity<ResponseObject> getInfo(GetUserInfoRequest request) {
        return null;
    }


    @GetMapping("/getUserList")
    @RolesAllowed("admin")
    public ResponseEntity<ResponseObject> getUserList() {
        return new ResponseEntity<>(userService.findAllUser(),HttpStatus.OK);
    }
}
