package com.example.demo.controller;

import com.example.demo.domain.UserEntity;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        try {
            // 요청을 이용해 저장할 사용자 만들기
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .name(userDTO.getName())
                    .password(userDTO.getPassword())
                    .build();

            // 서비스를 이용해 Repository에 사용자 저장
            UserEntity registeredUser = userService.create(user);

            UserDTO responseUserDTO = UserDTO.builder()
                    .email(registeredUser.getEmail())
                    .name(registeredUser.getName())
                    .password(registeredUser.getPassword())
                    .id(registeredUser.getId())
                    .build();

            return ResponseEntity.ok().body(responseUserDTO);

        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO){
        UserEntity user = userService.getByCredentials(
                userDTO.getEmail(),
                userDTO.getPassword()
        );

        if(user != null){
            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(user.getId())
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        }else{
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login failed")
                    .build();
            return ResponseEntity.ok().body(responseDTO);
        }
    }
}
