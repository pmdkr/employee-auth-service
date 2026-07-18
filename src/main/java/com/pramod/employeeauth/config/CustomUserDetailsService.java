package com.pramod.employeeauth.config;

import com.pramod.employeeauth.model.entity.CustomUserDetails;
import com.pramod.employeeauth.model.entity.User;
import com.pramod.employeeauth.repository.UserRepository;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService implements UserDetailsService {

    Logger log = (Logger) LoggerFactory.getLogger(CustomUserDetailsService.class);


    UserRepository userRepository;

    CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    Map<String, User> userMap = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //check if the user present in userMap, return the user from map
        if (userMap.containsKey(username)) {
            log.info("User found in cache {}", username);
            return new CustomUserDetails(userMap.get(username));
        } else {
            log.info("User not found in cache {}", username);

            User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

            log.info("Loading user in cache {}", username);
            userMap.put(username, user);
            return new CustomUserDetails(user);
        }
    }
}
