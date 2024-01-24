package com.vangogames.vangogames.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.vangogames.vangogames.Dao.UserRepository;

public class CustomUserDetailsService {

    @Autowired
    private UserRepository userRepository;

}
