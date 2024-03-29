package com.novianto.task.list.service.impl;

import com.novianto.task.list.domain.user.User;
import com.novianto.task.list.service.AuthService;
import com.novianto.task.list.service.UserService;
import com.novianto.task.list.web.dto.auth.JwtRequest;
import com.novianto.task.list.web.dto.auth.JwtResponse;
import com.novianto.task.list.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        JwtResponse response = new JwtResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        User user = userService.getByUsername(loginRequest.getUsername());
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getUsername(), user.getRoles()));
        response.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUsername()));
        return response;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
