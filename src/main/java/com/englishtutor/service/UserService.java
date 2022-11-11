package com.englishtutor.service;

import com.englishtutor.dtos.request.user.RegisterUserRequest;
import com.englishtutor.dtos.response.user.RegisterUserResponse;
import com.englishtutor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
