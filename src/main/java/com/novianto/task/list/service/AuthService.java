package com.novianto.task.list.service;

import com.novianto.task.list.web.dto.auth.JwtRequest;
import com.novianto.task.list.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
