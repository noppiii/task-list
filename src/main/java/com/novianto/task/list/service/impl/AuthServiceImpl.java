package com.novianto.task.list.service.impl;

import com.novianto.task.list.service.AuthService;
import com.novianto.task.list.web.dto.auth.JwtRequest;
import com.novianto.task.list.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
