package com.solera.crm.controller;

import com.solera.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping("test")
    public String test() {
        return "TEST";
    }

    @PostMapping("login")
    public boolean login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        return service.login(username, password);
    }
}
