package com.solera.crm.service;

import com.solera.crm.entity.User;
import com.solera.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.repo = userRepository;
    }

    // Checks if user exists and log in
    public boolean login(String username, String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hashedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();

        User user = repo.findByUsernameAndPassword(username, hashedPassword);
        return user != null;
    }
}
