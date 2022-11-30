package com.solera.crm.controller;

import com.solera.crm.entity.User;
import com.solera.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public User login(@RequestBody Map<String, String> data) {
        return this.userService.login(data);
    }
}
