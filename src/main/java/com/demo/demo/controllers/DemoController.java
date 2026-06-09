package com.demo.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entities.User;
import com.demo.demo.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final UserService userService;

    @GetMapping("/")
    public String Get() {
        return "Hello";
    }

    @GetMapping("/users")
    public List<User> getUsersList() {
        try {
            var ss = userService.getUsersList();
            return ss;
        } catch (Exception e) {
            return null;
        }

    }
}
