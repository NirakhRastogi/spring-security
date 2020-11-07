package com.security.basic.basicspringbootsecurity.security;

public enum ApplicationPermission {

    READ("read"),
    WRITE("write");

    private final String permission;

    ApplicationPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
