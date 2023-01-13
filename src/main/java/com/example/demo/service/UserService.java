package com.example.demo.service;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity create(final UserEntity userEntity){

        // 데이터 유무 검증
        if(userEntity == null || userEntity.getEmail() == null){
            throw new RuntimeException("Invalid arguments");
        }
        // 이메일 검증
        // 이미 등록된 이메일이면, RuntimeException 발생
        // 중복 이메일 가입 방지
        final String email = userEntity.getEmail();
        if (userRepository.existsByEmail(email)) {
            log.warn("Email already exists {}", email);
            throw new RuntimeException("Email already exists");
        }

        // 유저정보를 DB 에 저장 후, 컨트롤러에 결과값 반환함.
        return userRepository.save(userEntity);
    }

    public UserEntity getByCredentials(final String email, final String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
}
