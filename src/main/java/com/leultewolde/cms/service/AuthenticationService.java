package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.AuthenticationRequestDTO;
import com.leultewolde.cms.dto.request.RegisterRequestDTO;
import com.leultewolde.cms.dto.response.AuthenticationResponseDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO register(RegisterRequestDTO requestDTO);
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO requestDTO);
}
