package com.example.xinhang_practise.service;

import com.example.xinhang_practise.entity.User;
import com.example.xinhang_practise.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {


    private UserRepository userRepository;

    public User saveUser(User user) {

        return userRepository.save(user);


    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
