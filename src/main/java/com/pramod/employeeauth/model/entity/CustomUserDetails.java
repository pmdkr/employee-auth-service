package com.pramod.employeeauth.model.entity;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {


    private User user;

    public CustomUserDetails(User user) {
        this.user = user;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        // create a map for autherities

        List<GrantedAuthority> authorities = new ArrayList<>();


        Arrays.stream(user.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .forEach(authorities::add);


        Arrays.stream(user.getAuthority().split(","))
                .map(SimpleGrantedAuthority::new)
                .forEach(authorities::add);

        //
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
