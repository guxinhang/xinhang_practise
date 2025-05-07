package com.example.xinhang_practise.repository;

import com.example.xinhang_practise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUserId(String name);
}
