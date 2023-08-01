package com.example.loggingjwt.Services;

import com.example.loggingjwt.Auth.AuthResponse;
import com.example.loggingjwt.Auth.LoginRequest;
import com.example.loggingjwt.Auth.SignUpRequest;
import com.example.loggingjwt.Entity.Role;
import com.example.loggingjwt.Entity.User;
import com.example.loggingjwt.Jwt.JwtService;
import com.example.loggingjwt.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse signUp(SignUpRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .country(request.getCountry())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
