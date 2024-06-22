package com.leultewolde.cms.controller;

import com.google.gson.Gson;
import com.leultewolde.cms.config.JwtFilter;
import com.leultewolde.cms.config.JwtService;
import com.leultewolde.cms.config.SecurityConfig;
import com.leultewolde.cms.dto.request.AuthenticationRequestDTO;
import com.leultewolde.cms.dto.request.RegisterRequestDTO;
import com.leultewolde.cms.dto.response.AuthenticationResponseDTO;
import com.leultewolde.cms.dto.response.UserResponseDTO;
import com.leultewolde.cms.model.enums.Role;
import com.leultewolde.cms.service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AuthenticationController.class)
@Import({SecurityConfig.class, AuthenticationControllerTest.TestConfig.class})
class AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private JwtFilter jwtFilter;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Configuration
    static class TestConfig {
        @Bean
        public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsService);
            provider.setPasswordEncoder(passwordEncoder);
            return provider;
        }
    }

    @Test
    void register() throws Exception {
        RegisterRequestDTO requestDTO = new RegisterRequestDTO("Leul", "Tewolde", "leultewolde", "pass1234", Role.ADMINISTRATOR);
        UserResponseDTO userResponseDTO = new UserResponseDTO(1, "leultewolde", Role.ADMINISTRATOR);
        AuthenticationResponseDTO responseDTO = new AuthenticationResponseDTO("dummy-jwt-token", userResponseDTO);
        Mockito.when(authenticationService.register(Mockito.any(RegisterRequestDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(requestDTO))
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                );
    }

    @Test
    void authenticate() throws Exception {
        AuthenticationRequestDTO requestDTO = new AuthenticationRequestDTO("leultewolde", "pass1234");
        UserResponseDTO userResponseDTO = new UserResponseDTO(1, "leultewolde", Role.ADMINISTRATOR);
        AuthenticationResponseDTO responseDTO = new AuthenticationResponseDTO("dummy-jwt-token", userResponseDTO);
        Mockito.when(authenticationService.authenticate(Mockito.any(AuthenticationRequestDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(requestDTO))
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                );
    }
}