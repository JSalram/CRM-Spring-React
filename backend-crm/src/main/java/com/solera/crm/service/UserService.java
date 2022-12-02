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
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    // Generates token for User
    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    // Encrypts password
    private static String encryptPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    // Checks if user exists and log in
    public User login(Map<String, String> data) {
        User user = getUser(data);
        if (user != null) {
            user.setToken(generateNewToken());
            this.userRepository.flush();
        }
        return getUser(data);
    }

    // Finds user from data
    public User getUser(Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");

        String hashedPassword = encryptPassword(password);
        if (hashedPassword == null) return null;

        return userRepository.findByUsernameAndPassword(username, hashedPassword);
    }

    public User getUserByToken(String token) {
        if (token.isEmpty()) {
            return null;
        }
        Optional<User> user = this.userRepository.findByToken(token);
        return user.orElse(null);
    }

    public boolean unauthorizedUser(String token) {
        return getUserByToken(token) == null;
    }
}
