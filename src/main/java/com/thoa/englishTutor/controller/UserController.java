package com.thoa.englishTutor.controller;

import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.controller.interfaces.IUserController;
import com.thoa.englishTutor.dtos.request.user.*;
import com.thoa.englishTutor.enums.UserRole;
import com.thoa.englishTutor.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
@Slf4j
public class UserController implements IUserController {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<ResponseObject> checkEmailIfExist(String email) {
        return new ResponseEntity(userService.checkEmailIfExist(new CheckEmailIfExistRequest(email)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseObject> studentRegister(RegisterUserRequest request) {
        return new ResponseEntity<>(userService.register(request, UserRole.ROLE_STUDENT),HttpStatus.OK);
    }

    @Override
    @PostMapping("/tutorRegister")
    public ResponseEntity<ResponseObject> tutorRegister(RegisterUserRequest request) {
        return new ResponseEntity<>(userService.register(request, UserRole.ROLE_TUTOR),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseObject> update(Principal principal, UpdateUserRequest request) {
        return new ResponseEntity<>(userService.updateUserInformation(principal.getName(), request),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseObject> updateAvatar(UpdateAvatarRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> getInfo(Principal principal) {
        return new ResponseEntity<>(userService.getUserInfo(principal.getName()),HttpStatus.OK);
    }

    @Override
    @RolesAllowed("admin")
    public ResponseEntity<ResponseObject> getUserList(Principal principal) {
        return new ResponseEntity<>(userService.findAllUser(),HttpStatus.OK);
    }
}
