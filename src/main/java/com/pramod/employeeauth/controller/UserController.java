package com.pramod.employeeauth.controller;

import com.pramod.employeeauth.model.entity.User;
import com.pramod.employeeauth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User response = userService.saveUser(user);

        return new ResponseEntity<>(response, HttpStatus.OK);


    }
}
