package com.pramod.employeeauth.controller;


import com.pramod.employeeauth.model.entity.User;
import com.pramod.employeeauth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/getalluser")
    public ResponseEntity<List<User>> getAllEmployee() {
        List<User> response = userService.getAllUsers();

        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    ;
}
