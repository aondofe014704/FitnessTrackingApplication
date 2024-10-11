package com.semicolon.africa.fitnesstrackersystem.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private boolean isLoggedIn;
    private String address;
    @Enumerated(EnumType.STRING)
    private  Gender gender;
    @OneToMany
    List<Workout> workoutList;
}
