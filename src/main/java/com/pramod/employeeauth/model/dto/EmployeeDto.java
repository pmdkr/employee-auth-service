package com.pramod.employeeauth.model.dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeDto {

    private Long id;
    private String username;
    private String password;
    private String role;
    private String authority;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String username, String password, String role, String authority) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
