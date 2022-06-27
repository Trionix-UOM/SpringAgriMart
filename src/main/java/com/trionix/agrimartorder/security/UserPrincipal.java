package com.trionix.agrimartorder.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trionix.agrimartorder.constant.Role;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Map;


@Data
public class UserPrincipal implements UserDetails {
    public Object getId;
    @JsonProperty
    private String  id;
    @JsonProperty
    private String email;
    @JsonProperty
    private Map<String, Object> attributes;

    @JsonProperty
    private Collection<Role> authorities;

    @Override
    public Collection<Role> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
