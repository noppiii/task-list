package com.novianto.task.list.web.controller;

import com.novianto.task.list.domain.user.User;
import com.novianto.task.list.service.AuthService;
import com.novianto.task.list.service.UserService;
import com.novianto.task.list.web.dto.auth.JwtRequest;
import com.novianto.task.list.web.dto.auth.JwtResponse;
import com.novianto.task.list.web.dto.user.UserDto;
import com.novianto.task.list.web.dto.validation.OnCreate;
import com.novianto.task.list.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest request) {
        return  authService.login(request);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createUser = userService.create(user);
        return userMapper.toDto(createUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
