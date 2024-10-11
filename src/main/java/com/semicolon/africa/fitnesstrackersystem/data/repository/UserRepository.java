package com.semicolon.africa.fitnesstrackersystem.data.repository;

import com.semicolon.africa.fitnesstrackersystem.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
