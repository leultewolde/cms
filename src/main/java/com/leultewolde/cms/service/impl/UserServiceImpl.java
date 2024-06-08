package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.dto.request.UserRequestDTO;
import com.leultewolde.cms.dto.response.UserResponseDTO;
import com.leultewolde.cms.mapper.UserMapper;
import com.leultewolde.cms.model.User;
import com.leultewolde.cms.repository.UserRepository;
import com.leultewolde.cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public Optional<UserResponseDTO> updateUser(Integer userId, UserRequestDTO userRequestDTO) {
        return userRepository.findById(userId)
                .map(existingUser -> {
                    userMapper.updateEntityFromDTO(userRequestDTO, existingUser);
                    return userMapper.toDTO(userRepository.save(existingUser));
                });
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<UserResponseDTO> getUserById(Integer userId) {
        return userRepository.findById(userId).map(userMapper::toDTO);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userMapper.toDTO(userRepository.findAll());
    }
}
