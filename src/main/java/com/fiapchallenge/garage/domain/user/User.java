package com.fiapchallenge.garage.domain.user;

import java.util.UUID;

public class User {

    private UUID id;
    private String fullname;
    private String email;
    private String password;
    private UserRole role;

    public User(UUID id, String fullname, String email, String password, UserRole role) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}
