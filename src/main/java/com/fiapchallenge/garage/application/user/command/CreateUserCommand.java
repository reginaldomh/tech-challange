package com.fiapchallenge.garage.application.user.command;

import com.fiapchallenge.garage.domain.user.UserRole;

public record CreateUserCommand(
        String fullname,
        String email,
        String password,
        UserRole role
) {
}
