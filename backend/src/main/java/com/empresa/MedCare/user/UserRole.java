package com.empresa.MedCare.user;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_ADMIN("ADMIN"),
    ROLE_PATIENT("PATIENT"),
    ROLE_DOCTOR("DOCTOR"),
    ROLE_RECEPTIONIST("RECEPTIONIST");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return name();
    }

    public String getDescription() {
        return description;
    }
}
