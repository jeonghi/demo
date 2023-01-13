package com.example.demo.repository;

import com.example.demo.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByEmail(String email);

    Boolean existsByEmail(String email);

    UserEntity findByEmailAndPassword(String email, String password);
}
