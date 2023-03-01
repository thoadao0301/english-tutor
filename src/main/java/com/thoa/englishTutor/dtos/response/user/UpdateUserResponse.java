package com.thoa.englishTutor.dtos.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserResponse {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Date birthday;
}
