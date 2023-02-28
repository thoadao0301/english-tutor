package com.thoa.englishTutor.dtos.dto;

import com.thoa.englishTutor.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Date birthday;

    private UserRole role;
}
