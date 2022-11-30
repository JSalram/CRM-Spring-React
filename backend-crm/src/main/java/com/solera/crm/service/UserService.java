package com.solera.crm.service;

import com.solera.crm.entity.User;
import com.solera.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository repo;
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    // Generates token for User
    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.repo = userRepository;
    }

    // Checks if user exists and log in
    public User login(Map<String, String> data) {
        User user = getUser(data);
        if (user != null) {
            user.setToken(generateNewToken());
            this.repo.flush();
        }
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
