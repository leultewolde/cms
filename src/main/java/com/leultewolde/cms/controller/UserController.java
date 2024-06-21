package com.leultewolde.cms.controller;

import com.leultewolde.cms.dto.request.TaskRequestDTO;
import com.leultewolde.cms.dto.request.UserRequestDTO;
import com.leultewolde.cms.dto.response.TaskQueueResponseDTO;
import com.leultewolde.cms.dto.response.TaskResponseDTO;
import com.leultewolde.cms.dto.response.UserResponseDTO;
import com.leultewolde.cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/{username}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable String username, @RequestBody UserRequestDTO userRequestDTO) {
        Optional<UserResponseDTO> updatedUser = userService.updateUser(username, userRequestDTO);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        String resp = userService.deleteUser(username);
        if (resp != null) {
            return ResponseEntity.ok(resp);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDTO> getUserByUsername(@PathVariable String username) {
        Optional<UserResponseDTO> user = userService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
