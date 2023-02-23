package com.thoa.englishTutor.dtos.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class UpdateUserRequest {
    @NotEmpty(message = "The field is not empty")
    private String firstName;

    @NotEmpty(message = "The field is not empty")
    private String lastName;

    @NotEmpty(message = "The field is not empty")
    @Size(min = 10, max = 10)
    private String phoneNumber;

    @NotEmpty(message = "The field is not empty")
    private Date birthday;
}
