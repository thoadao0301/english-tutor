package com.thoa.englishTutor.dtos.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
public class CheckEmailIfExistRequest {
    @NotEmpty(message = "The field is not empty")
    @Email
    private String email;
}
