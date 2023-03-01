package com.thoa.englishTutor.dtos.response.user;

import com.thoa.englishTutor.enums.UserRole;
import com.thoa.englishTutor.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RegisterUserResponse {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Date birthday;

    private UserRole role;

    public RegisterUserResponse(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.birthday = user.getBirthday();
        this.role = user.getRole();
    }
}
