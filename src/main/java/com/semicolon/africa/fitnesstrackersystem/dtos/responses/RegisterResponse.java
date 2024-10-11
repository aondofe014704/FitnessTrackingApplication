package com.semicolon.africa.fitnesstrackersystem.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterResponse {
    private Long userId;
    private String email;
    private String response;
}
