package com.pramod.employeeauth.service.Impl;

import com.pramod.employeeauth.model.entity.User;
import com.pramod.employeeauth.repository.UserRepository;
import com.pramod.employeeauth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) {
        logger.info("Saving user with name {}", user.getUsername());
        User savedUser = userRepository.save(user);

        logger.info("User saved successfully with id: {}", savedUser.getId());
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
