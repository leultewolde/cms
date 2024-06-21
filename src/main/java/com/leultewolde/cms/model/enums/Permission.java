package com.leultewolde.cms.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),
    CONTRIBUTOR_READ("contributor:read"),
    CONTRIBUTOR_WRITE("contributor:write"),
    REVIEWER_READ("reviewer:read"),
    REVIEWER_WRITE("reviewer:write");

    public final String permission;
}
