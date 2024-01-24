package com.vangogames.vangogames.Entities;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class FetchUser {

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id")
    private String username;
    @Size(min = 8, message = "Password cannot be less than 8 characters")
    private String password;

    public FetchUser() {
    }

    public String getUsername() {
        return username;
    }

    public FetchUser(
            @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id") String username,
            @Size(min = 8, message = "Password cannot be less than 8 characters") String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "FetchUser [username=" + username + ", password=" + password + "]";
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

}
