package com.demo.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.demo.entities.User;
import com.demo.demo.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersList() {
        return userRepository.findAll();
    }
}
