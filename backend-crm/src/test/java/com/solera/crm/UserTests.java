package com.solera.crm;

import com.solera.crm.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class UserTests {

    private UserService userService;

    @Autowired
    public UserTests(UserService userService) {
        this.userService = userService;
    }

    @Test
    void login_successful() {
        Map<String, String> data = new HashMap<>();
        data.put("username", "admin");
        data.put("password", "admin");
        boolean logged = this.userService.login(data);
        Assertions.assertTrue(logged);
    }

    @Test
    void login_failure() {
        Map<String, String> data = new HashMap<>();
        data.put("username", "error");
        data.put("password", "error");
        boolean logged = this.userService.login(data);
        Assertions.assertFalse(logged);
    }
}
