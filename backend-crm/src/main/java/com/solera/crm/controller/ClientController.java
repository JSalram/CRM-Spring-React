package com.solera.crm.controller;

import com.solera.crm.entity.Client;
import com.solera.crm.entity.User;
import com.solera.crm.service.ClientService;
import com.solera.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients(@CookieValue(name = "token", defaultValue = "") String token) {
        if (userService.unauthorizedUser(token)) {
            return null;
        }
        User user = userService.getUserByToken(token);
        if (user == null) return null;
        return clientService.findClientsByUser(user);
    }
}
