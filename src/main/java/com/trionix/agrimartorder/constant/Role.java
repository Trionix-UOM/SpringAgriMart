package com.trionix.agrimartorder.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    USER,
    ADMIN;

    public String getAuthority() {
        return this.name();
    }

    @JsonValue
    public String toValue() {
        return toString();
    }
}
