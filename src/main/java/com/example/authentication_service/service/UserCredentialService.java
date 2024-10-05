package com.example.authentication_service.service;

import com.example.authentication_service.dao.UserCredentialRepo;
import com.example.authentication_service.dao.entity.UserCredentialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {
    @Autowired
    JwtService jwtService;
    @Autowired
    UserCredentialRepo userCredentialRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserCredentialEntity register(UserCredentialEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userCredentialRepo.saveAndFlush(user);
    }
    public String generateToken(String name) {
        return jwtService.generateToken(name);
    }
    public boolean verifyToken(String token) {
        jwtService.validateToken(token);
        return true;
    }
}

