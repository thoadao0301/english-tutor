package com.thoa.englishTutor.Service;

import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.dtos.request.user.CheckEmailIfExistRequest;
import com.thoa.englishTutor.dtos.request.user.RegisterUserRequest;
import com.thoa.englishTutor.dtos.response.user.CheckEmailIfExistResponse;
import com.thoa.englishTutor.dtos.response.user.RegisterUserResponse;
import com.thoa.englishTutor.enums.UserRole;
import com.thoa.englishTutor.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void testEmailIsNotExisted() {
        ResponseObject<CheckEmailIfExistResponse> responseObject = userService.checkEmailIfExist(
                new CheckEmailIfExistRequest("thoa123@gmsil.com"));
        Assertions.assertFalse(responseObject.getData().isExisted());
    }

    @Test
    void testCreateUser(){
        ResponseObject<RegisterUserResponse> responseObject = userService.register(
                new RegisterUserRequest("thoa123@gmail.com","thoa123","thoa123"), UserRole.ROLE_STUDENT);
        Assertions.assertEquals(0,responseObject.getStatusCode());
    }

    @Test
    void testEmailIsExisted() {
        ResponseObject<CheckEmailIfExistResponse> responseObject = userService.checkEmailIfExist(
                new CheckEmailIfExistRequest("thoa123@gmail.com"));
        Assertions.assertTrue(responseObject.getData().isExisted());
    }
}
