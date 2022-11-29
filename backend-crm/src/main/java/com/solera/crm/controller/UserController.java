package com.solera.crm.controller;

import com.solera.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("test")
    public String test() {
        return "TEST";
    }

    @PostMapping("login")
    public boolean login(@RequestBody Map<String, String> data) {
        return this.userService.login(data);
    }
}
