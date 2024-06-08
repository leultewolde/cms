package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.UserRequestDTO;
import com.leultewolde.cms.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    Optional<UserResponseDTO> updateUser(Integer userId, UserRequestDTO userRequestDTO);

    void deleteUser(Integer userId);

    Optional<UserResponseDTO> getUserById(Integer userId);

    List<UserResponseDTO> getAllUsers();
}



