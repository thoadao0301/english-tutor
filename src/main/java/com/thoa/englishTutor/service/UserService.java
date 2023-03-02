package com.thoa.englishTutor.service;

import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.dtos.dto.UserDto;
import com.thoa.englishTutor.dtos.request.user.CheckEmailIfExistRequest;
import com.thoa.englishTutor.dtos.request.user.RegisterUserRequest;
import com.thoa.englishTutor.dtos.request.user.UpdateUserRequest;
import com.thoa.englishTutor.dtos.response.user.*;
import com.thoa.englishTutor.enums.ResponseCode;
import com.thoa.englishTutor.enums.UserRole;
import com.thoa.englishTutor.model.User;
import com.thoa.englishTutor.repository.UserRepository;
import com.thoa.englishTutor.utils.ObjectMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KeycloakService keycloakService;

    public ResponseObject checkEmailIfExist(CheckEmailIfExistRequest request){
        ResponseObject<CheckEmailIfExistResponse> responseObject = new ResponseObject<>();
        if (userRepository.existsByEmail(request.getEmail())){
            return responseObject.success(new CheckEmailIfExistResponse(true));
        }
        return responseObject.success(new CheckEmailIfExistResponse(false));
    }

    public ResponseObject register(RegisterUserRequest request, UserRole role){
        ResponseObject<RegisterUserResponse> responseObject = new ResponseObject<>();
        if (userRepository.existsByEmail(request.getEmail())){
            log.info(ResponseCode.USER_EXISTED.getMessage());
            return responseObject.businessError(ResponseCode.USER_EXISTED);
        }
        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setRole(role);

        String userId = null;

        try {
            userId = keycloakService.createUserInKeyCloak(newUser, request.getPassword());
            if (userId == null){
                throw new RuntimeException("Keycloak gets errors and returns null at userID");
            }
        }catch (Exception e){
            log.error("Keycloak gets errors");
            return responseObject.fail();
        }

        newUser.setId(userId);
        User saveUser = null;
        try {
            saveUser = userRepository.save(newUser);
        }catch (Exception e){
            log.error("User repository gets error {}", e.getMessage());
            try {
                keycloakService.removeUserOnKeycloak(userId);
            }catch (Exception ke){
                log.warn("because user repository gets trouble so need to delete user in keycloak \n" +
                        "but keycloak can not delete user");
            }
            return responseObject.fail();
        }

        return responseObject.success(new RegisterUserResponse(saveUser));
    }

    public ResponseObject findAllUser(){
        ResponseObject<GetUserListResponse> responseObject = new ResponseObject<>();
        try {
            Iterable<User> users = userRepository.findAll();
            List<UserDto> userDtoList = new ArrayList<>();
            users.forEach(user -> {
                UserDto userDto = ObjectMapperUtil.objectMapper(user, UserDto.class);
                userDtoList.add(userDto);
            });
            return responseObject.success(new GetUserListResponse(userDtoList));
        }catch (Exception e){
            e.printStackTrace();
            log.error("find all user gets error");
            return responseObject.fail();
        }
    }

    public ResponseObject updateUserInformation(String id,UpdateUserRequest request){
        ResponseObject<UpdateUserResponse> responseObject = new ResponseObject<>();
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isEmpty()){
                return responseObject.businessError(ResponseCode.USER_NOT_EXISTED);
            }
            User user = userOptional.get();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setBirthday(request.getBirthday());
            user.setPhoneNumber(request.getPhoneNumber());

            User saveUser = userRepository.save(user);
            return responseObject.success(ObjectMapperUtil.objectMapper(saveUser, UpdateUserResponse.class));
        }catch (Exception e){
            e.printStackTrace();
            log.error("Updating user's information gets error");
            return responseObject.fail();
        }
    }

    public ResponseObject getUserInfo(String id){
        ResponseObject<GetUserInfoResponse> responseObject = new ResponseObject<>();
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isEmpty()){
                return responseObject.businessError(ResponseCode.USER_NOT_EXISTED);
            }
            return responseObject.success(ObjectMapperUtil.objectMapper(userOptional.get(),GetUserInfoResponse.class));
        }catch (Exception e){
            e.printStackTrace();
            log.error("Getting user's information gets error");
            return responseObject.fail();
        }
    }
}
