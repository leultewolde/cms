package com.leultewolde.cms.controller;

import com.google.gson.Gson;
import com.leultewolde.cms.config.SecurityConfig;
import com.leultewolde.cms.dto.request.UserRequestDTO;
import com.leultewolde.cms.dto.response.UserResponseDTO;
import com.leultewolde.cms.model.enums.Role;
import com.leultewolde.cms.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser
    void createUser() throws Exception {
        UserResponseDTO newUser = new UserResponseDTO(1, "leultewolde", Role.ADMINISTRATOR);
        Mockito.when(userService.createUser(Mockito.any(UserRequestDTO.class))).thenReturn(newUser);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new Gson().toJson(
                                        new UserRequestDTO("leultewolde", "pass1234", "leultewolde@email.com", Role.ADMINISTRATOR
                                        )))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(new Gson().toJson(newUser)));
    }

    @Test
    void updateUser() throws Exception {
        UserResponseDTO updatedUserResponse = new UserResponseDTO(1, "leultewolde", Role.ADMINISTRATOR);
        UserRequestDTO updatedUser = new UserRequestDTO("leultewolde", "pass1234", "leultewolde@email.com", Role.ADMINISTRATOR);

        Mockito.when(userService.updateUser("leultewolde", updatedUser)).thenReturn(Optional.of(updatedUserResponse));

        mockMvc.perform(
                        MockMvcRequestBuilders.put("/users/leultewolde")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new Gson().toJson(updatedUser))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(new Gson().toJson(updatedUserResponse)));
    }

    @Test
    void deleteUser() throws Exception {
        Mockito.when(userService.deleteUser("leultewolde")).thenReturn("DELETED");

        mockMvc.perform(MockMvcRequestBuilders.delete("/users/leultewolde"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("DELETED"));
    }

    @Test
    void getUserByUsername() throws Exception {
        UserResponseDTO foundUser = new UserResponseDTO(1, "leultewolde", Role.ADMINISTRATOR);
        Mockito.when(userService.getUserByUsername("leultewolde")).thenReturn(Optional.of(foundUser));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/leultewolde"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new Gson().toJson(foundUser)));
    }

    @Test
    void getAllUsers() throws Exception {
        List<UserResponseDTO> foundUsers = List.of(
                new UserResponseDTO(1, "leultewolde", Role.ADMINISTRATOR),
                new UserResponseDTO(2, "test1", Role.CONTRIBUTOR),
                new UserResponseDTO(3, "test2", Role.REVIEWER)
        );
        Mockito.when(userService.getAllUsers()).thenReturn(foundUsers);

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new Gson().toJson(foundUsers)));
    }
}