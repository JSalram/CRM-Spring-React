package com.solera.crm;

import com.solera.crm.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {

    private UserService service;

    @Autowired
    public UserTests(UserService userService) {
        this.service = userService;
    }

    @Test
    void login_successful() {
        boolean logged = service.login("admin", "admin");
        Assertions.assertTrue(logged);
    }

    @Test
    void login_failure() {
        boolean logged = service.login("error", "error");
        Assertions.assertFalse(logged);
    }
}
