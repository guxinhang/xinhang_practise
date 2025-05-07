package com.example.xinhang_practise.controller;

import com.example.xinhang_practise.entity.User;
import com.example.xinhang_practise.repository.UserRepository;
import com.example.xinhang_practise.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;


    @Test
    void testSaveUser() {
        User user = User.builder().id(1L).name("Bruce").birth("2025-05-07").gender("Male").role("Developer").build();
        ResponseEntity<User> resp = ResponseEntity.status(HttpStatus.CREATED).body(User.builder().id(user.getId()).build());
        when(userService.saveUser(user)).thenReturn(user);

        ResponseEntity<User> result = userController.saveUser(user);
        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(1L, result.getBody().getId());
    }


    @Test
    void testGetUser() {
        User user = User.builder().id(1L).name("Bruce").birth("2025-05-07").gender("Male").role("Developer").build();
        ResponseEntity<User> resp = ResponseEntity.status(HttpStatus.CREATED).body(User.builder().id(user.getId()).build());
        when(userService.getUserById(1L)).thenReturn(user);

        ResponseEntity<User> result = userController.getUserById(1L);
        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals("Bruce", result.getBody().getName());

    }
}
