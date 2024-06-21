package com.leultewolde.cms.dto.request;

import com.leultewolde.cms.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserRequestDTO {
    private String username;
    private String password;
    private String email;
    private Role role;
}
