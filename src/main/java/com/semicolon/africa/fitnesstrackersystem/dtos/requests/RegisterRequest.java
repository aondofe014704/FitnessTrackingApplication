package com.semicolon.africa.fitnesstrackersystem.dtos.requests;

import com.semicolon.africa.fitnesstrackersystem.data.models.Gender;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private Gender gender;

}
