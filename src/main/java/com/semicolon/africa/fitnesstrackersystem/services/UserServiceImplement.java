package com.semicolon.africa.fitnesstrackersystem.services;

import com.semicolon.africa.fitnesstrackersystem.configuration.Mappers;
import com.semicolon.africa.fitnesstrackersystem.data.models.User;
import com.semicolon.africa.fitnesstrackersystem.data.repository.UserRepository;
import com.semicolon.africa.fitnesstrackersystem.dtos.requests.RegisterRequest;
import com.semicolon.africa.fitnesstrackersystem.dtos.responses.RegisterResponse;
import com.semicolon.africa.fitnesstrackersystem.exceptions.FitnessTrackerSystemException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    @Override
    public RegisterResponse register(RegisterRequest request) {
       validateUserEmail(request.getEmail().trim().toLowerCase());
       passwordEncoder.encode(request.getPassword());
       User user = modelMapper.map(request, User.class);
       userRepository.save(user);
       RegisterResponse response = modelMapper.map(user, RegisterResponse.class);
       response.setResponse("Success");
       response.setEmail(response.getEmail());
       response.setUserId(response.getUserId());
        return response;
    }
    private void validateUserEmail(String email){
        boolean existsByEmail = userRepository.existsByEmail(email);
        if(existsByEmail) throw new FitnessTrackerSystemException("Email already exists");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
