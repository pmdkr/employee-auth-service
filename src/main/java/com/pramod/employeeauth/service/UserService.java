package com.pramod.employeeauth.service;

import com.pramod.employeeauth.model.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    User getSingleUser(Long id);

    List<User> getAllUsers();


}
