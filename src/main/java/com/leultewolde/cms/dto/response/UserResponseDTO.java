package com.leultewolde.cms.dto.response;

import com.leultewolde.cms.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserResponseDTO {
    private Integer userId;
    private String username;
    private Role role;
}
