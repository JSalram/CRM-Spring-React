package com.solera.crm.controller;

import com.solera.crm.entity.User;
import com.solera.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public Map<String, Object> login(HttpServletResponse response, @RequestBody Map<String, String> data) {
        User user = this.userService.login(data);
        if (user == null) {
            return null;
        }

        // Adding httpOnly cookie TOKEN
        Cookie token = new Cookie("token", user.getToken());
        token.setMaxAge(7 * 24 * 60 * 60); // 1 week
        token.setSecure(true);
        token.setHttpOnly(true);
        token.setPath("");
        response.addCookie(token);

        // Return mapping
        Map<String, Object> object = new HashMap<>();
        object.put("userId", user.getId());
        object.put("token", user.getToken());
        return object;
    }
}
