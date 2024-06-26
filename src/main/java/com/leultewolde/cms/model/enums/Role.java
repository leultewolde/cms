package com.leultewolde.cms.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMINISTRATOR(
            Set.of(Permission.ADMIN_WRITE, Permission.ADMIN_READ)
    ),
    CONTRIBUTOR(
            Set.of(Permission.CONTRIBUTOR_WRITE, Permission.CONTRIBUTOR_READ)
    ),
    REVIEWER(
            Set.of(Permission.REVIEWER_WRITE, Permission.REVIEWER_READ)
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}

