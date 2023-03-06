package com.example.security.service;


import com.example.security.repos.IUserRepository;
import com.example.security.security.AuthenticationRequest;
import com.example.security.security.AuthenticationResponse;
import com.example.security.security.RegisterRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.security.domain.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IJwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterRequest request) {
      var user = User.builder()
              .firstname(request.getFirstname())
              .lastname(request.getLastname())
              .cin(request.getCin())
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              .roles(request.getRoles())
              .phone(request.getPhone())
              .address(request.getAddress())
              .profilepicture(request.getProfilepicture())
              .build();
              userRepository.save(user);
                var jwtToken = jwtService.generateTokenWithoutExtraClaims(user);
              return AuthenticationResponse.builder()
                      .token(jwtToken)
                      .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
       );
       var user = userRepository.findByEmail(request.getEmail()).orElse(null);
        var jwtToken = jwtService.generateTokenWithoutExtraClaims(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
