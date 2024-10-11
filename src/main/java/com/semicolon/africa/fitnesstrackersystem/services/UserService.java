package com.semicolon.africa.fitnesstrackersystem.services;

import com.semicolon.africa.fitnesstrackersystem.data.models.User;
import com.semicolon.africa.fitnesstrackersystem.dtos.requests.RegisterRequest;
import com.semicolon.africa.fitnesstrackersystem.dtos.responses.RegisterResponse;

import java.util.List;

public interface UserService {

    RegisterResponse register(RegisterRequest request);

    List<User> getAllUsers();

}
