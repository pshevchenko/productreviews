package com.astound.presentation.productreviews.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    ROLE_USER, ROLE_SUPPORT, ROLE_ADMIN;
    @Override
    public String getAuthority() {
        return toString();
    }
}
