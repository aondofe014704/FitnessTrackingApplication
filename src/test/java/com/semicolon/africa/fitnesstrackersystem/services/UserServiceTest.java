package com.semicolon.africa.fitnesstrackersystem.services;

import com.semicolon.africa.fitnesstrackersystem.data.models.Gender;
import com.semicolon.africa.fitnesstrackersystem.data.repository.UserRepository;
import com.semicolon.africa.fitnesstrackersystem.dtos.requests.RegisterRequest;
import com.semicolon.africa.fitnesstrackersystem.dtos.responses.RegisterResponse;
import com.semicolon.africa.fitnesstrackersystem.exceptions.FitnessTrackerSystemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest

class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();
    }
    @Test
    public void testThatUserCanRegister(){
        RegisterResponse response = userRegister();
        assertThat(response).isNotNull();
        assertThat(userService.getAllUsers()).size().isEqualTo(1L);
    }

    private RegisterResponse userRegister() {
        RegisterRequest request = new RegisterRequest();
        request.setAddress("Lagos, Yaba");
        request.setEmail("useer@gmail.com");
        request.setPassword("password");
        request.setGender(Gender.MALE);
        request.setPhoneNumber("1234567890");
        request.setUsername("user014704");
        RegisterResponse response = userService.register(request);
        return response;
    }
    @Test
    public void testThatUserCannotRegisterWithTheSameEmail(){
        userRegister();
        RegisterRequest request = new RegisterRequest();
        request.setAddress("Lagos, Yaba");
        request.setEmail("useer@gmail.com");
        request.setPassword("password");
        request.setGender(Gender.MALE);
        request.setPhoneNumber("1234567890");
        request.setUsername("user014704");
        assertThrows(FitnessTrackerSystemException.class, ()-> userService.register(request));
    }

}