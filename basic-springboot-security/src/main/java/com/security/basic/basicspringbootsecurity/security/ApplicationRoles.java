package com.security.basic.basicspringbootsecurity.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationRoles {

    ADMIN(Sets.newHashSet()),
    USER(Sets.newHashSet(ApplicationPermission.READ.getPermission(), ApplicationPermission.WRITE.getPermission())),
    USERTRAINEE(Sets.newHashSet(ApplicationPermission.READ.getPermission()));

    private final Set<String> permissions;

    ApplicationRoles(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getPermissions() {
        return this.permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = this.permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }


}
