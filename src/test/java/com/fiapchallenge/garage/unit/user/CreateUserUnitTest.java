package com.fiapchallenge.garage.unit.user;

import com.fiapchallenge.garage.application.user.CreateUserService;
import com.fiapchallenge.garage.application.user.command.CreateUserCommand;
import com.fiapchallenge.garage.domain.user.User;
import com.fiapchallenge.garage.domain.user.UserRepository;
import com.fiapchallenge.garage.unit.user.utils.factory.UserTestFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateUserUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CreateUserService createUserService;

    @Test
    @DisplayName("Criar usuário")
    void shouldCreateUser() {
        when(userRepository.create(any(User.class))).thenReturn(UserTestFactory.createUser());

        CreateUserCommand command = UserTestFactory.createUserCommand();
        User user = createUserService.handle(command);

        assertEquals(UserTestFactory.ID, user.getId());
        assertNotNull(UserTestFactory.FULLNAME, user.getFullname());
        assertNotNull(UserTestFactory.EMAIL, user.getEmail());
        assertNotNull(UserTestFactory.PASSWORD, user.getPassword());
    }
}
