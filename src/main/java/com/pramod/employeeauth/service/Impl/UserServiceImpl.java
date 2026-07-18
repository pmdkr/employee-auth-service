package com.pramod.employeeauth.service.Impl;

import com.pramod.employeeauth.model.entity.User;
import com.pramod.employeeauth.repository.UserRepository;
import com.pramod.employeeauth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) {
        log.info("Saving user with name {}", user.getUsername());
        User savedUser = userRepository.save(user);

        log.info("User saved successfully : {}", savedUser.getId());
        return savedUser;
    }

    @Override
    public User updateUser(Long id, User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User getSingleUser(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
