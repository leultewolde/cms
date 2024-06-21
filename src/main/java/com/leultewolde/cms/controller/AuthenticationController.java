package com.leultewolde.cms.controller;

import com.leultewolde.cms.dto.request.AuthenticationRequestDTO;
import com.leultewolde.cms.dto.request.RegisterRequestDTO;
import com.leultewolde.cms.dto.response.AuthenticationResponseDTO;
import com.leultewolde.cms.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO registerRequest) {
        AuthenticationResponseDTO response = authenticationService.register(registerRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationRequestDTO authenticationRequest) {
        AuthenticationResponseDTO response = authenticationService.authenticate(authenticationRequest);
        return ResponseEntity.ok(response);
    }
}
