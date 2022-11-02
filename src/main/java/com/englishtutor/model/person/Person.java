package com.englishtutor.model.person;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.UUID;

public class Person {
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false)
    @Email
    private String email;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "birthday")
    private Date birthday;

}
