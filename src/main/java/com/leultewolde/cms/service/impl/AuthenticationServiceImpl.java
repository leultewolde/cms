package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.config.JwtService;
import com.leultewolde.cms.dto.request.AuthenticationRequestDTO;
import com.leultewolde.cms.dto.request.RegisterRequestDTO;
import com.leultewolde.cms.dto.response.AuthenticationResponseDTO;
import com.leultewolde.cms.model.User;
import com.leultewolde.cms.repository.UserRepository;
import com.leultewolde.cms.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Override
    public AuthenticationResponseDTO register(RegisterRequestDTO requestDTO) {
        // Create a user
        User user = new User(
                requestDTO.getFirstname(),
                requestDTO.getLastname(),
                requestDTO.getUsername(),
                passwordEncoder.encode(requestDTO.getPassword()),
                requestDTO.getRole()
        );
        // Save user
        User savedUser = userRepository.save(user);
        //Generate a token
        String token = jwtService.generateToken(savedUser);

        return new AuthenticationResponseDTO(token);
    }

    @Override
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO requestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                requestDTO.getUsername(),
                requestDTO.getPassword()
        ));

        var user = userDetailsService.loadUserByUsername(requestDTO.getUsername());

        String token = jwtService.generateToken(user);

        return new AuthenticationResponseDTO(token);
    }
}
