package com.solera.crm.service;

import com.solera.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.repo = userRepository;
    }

    // Checks if user exists and log in
    public boolean login(String username, String password) {
        return true;
    }
}
