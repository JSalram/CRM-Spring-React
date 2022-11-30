package com.solera.crm.controller;

import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.service.OpportunityService;
import com.solera.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/opportunities")
public class OpportunityController {

    UserService userService;
    OpportunityService opportunityService;

    @Autowired
    public OpportunityController(UserService userService, OpportunityService opportunityService) {
        this.userService = userService;
        this.opportunityService = opportunityService;
    }

    @PostMapping
    public List<Opportunity> getOpportunities(@RequestBody Map<String, String> data) {
        User user = userService.getUser(data);
        if (user == null) return null;
        return this.opportunityService.findOpportunitiesByUser(user);
    }
}
