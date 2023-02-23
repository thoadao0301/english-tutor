package com.thoa.englishTutor.dtos.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    @Email
    @NotEmpty(message = "The field is not empty")
    private String email;

    @NotEmpty(message = "The field is not empty")
    private String password;

    @NotEmpty(message = "The field is not empty")
    private String confirmPassword;
}
