package com.solera.crm.service;

import com.solera.crm.entity.User;
import com.solera.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.repo = userRepository;
    }

    // Checks if user exists and log in
    public User login(Map<String, String> data) {
        return getUser(data);
    }

    // Finds user from data
    public User getUser(Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hashedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();

        return repo.findByUsernameAndPassword(username, hashedPassword);
    }
}
