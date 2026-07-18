package com.pramod.employeeauth.controller;

import com.pramod.employeeauth.model.entity.User;
import com.pramod.employeeauth.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
 logger.info("Received request to save user : {}", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User response = userService.saveUser(user);

        return new ResponseEntity<>(response, HttpStatus.OK);


    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello I am from employee-auth server";
    }

}
