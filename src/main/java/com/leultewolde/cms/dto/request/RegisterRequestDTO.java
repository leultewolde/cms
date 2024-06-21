package com.leultewolde.cms.dto.request;

import com.leultewolde.cms.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequestDTO {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Role role;
}
