package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.UserRequestDTO;
import com.leultewolde.cms.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    Optional<UserResponseDTO> updateUser(String username, UserRequestDTO userRequestDTO);

    String deleteUser(String username);

    Optional<UserResponseDTO> getUserByUsername(String username);

    List<UserResponseDTO> getAllUsers();
}



