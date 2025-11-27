package com.fiapchallenge.garage.adapters.outbound.entities;

import com.fiapchallenge.garage.domain.user.UserRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "\"user\"")
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String fullname;
    private String email;
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    public UserEntity() {
    }

    public UserEntity(UUID id, String fullname, String email, String password, UserRole role) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public UserEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public UserEntity setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public UserEntity setRole(UserRole role) {
        this.role = role;
        return this;
    }
}
