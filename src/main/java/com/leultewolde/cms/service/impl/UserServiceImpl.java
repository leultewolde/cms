package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.dto.request.UserRequestDTO;
import com.leultewolde.cms.dto.response.UserResponseDTO;
import com.leultewolde.cms.mapper.TaskMapper;
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
    private final TaskMapper taskMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public Optional<UserResponseDTO> updateUser(String username, UserRequestDTO userRequestDTO) {
        return userRepository.findUserByUsername(username)
                .map(existingUser -> {
                    userMapper.updateEntityFromDTO(userRequestDTO, existingUser);
                    return userMapper.toDTO(userRepository.save(existingUser));
                });
    }

    @Override
    public String deleteUser(String username) {
        Optional<User> foundUser = userRepository.findUserByUsername(username);
        if (foundUser.isPresent()) {
            userRepository.delete(foundUser.get());
            return "DELETED";
        }
        return null;
    }

    @Override
    public Optional<UserResponseDTO> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).map(userMapper::toDTO);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userMapper.toDTO(userRepository.findAll());
    }
}
