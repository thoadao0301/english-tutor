package com.thoa.englishTutor.dtos.response.user;

import com.thoa.englishTutor.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserInfoResponse {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Date birthday;

    private UserRole role;
}
