package com.example.xinhang_practise.service;

import com.example.xinhang_practise.entity.User;
import com.example.xinhang_practise.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = User.builder().id(1L).name("Bruce").birth("2025-05-07").gender("Male").role("Developer").build();
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.saveUser(user);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }


    @Test
    void testGetUser() {
        User user = User.builder().id(1L).name("Bruce").birth("2025-05-07").gender("Male").role("Developer").build();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("Bruce", result.getName());

    }
}
