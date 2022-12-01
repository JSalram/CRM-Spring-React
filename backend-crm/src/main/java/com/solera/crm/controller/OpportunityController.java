package com.solera.crm.controller;

import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.repository.OpportunityRepository;
import com.solera.crm.service.OpportunityService;
import com.solera.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/opportunities")
public class OpportunityController {

    UserService userService;
    OpportunityService opportunityService;
    OpportunityRepository opportunityRepository;

    @Autowired
    public OpportunityController(UserService userService, OpportunityService opportunityService, OpportunityRepository opportunityRepository) {
        this.userService = userService;
        this.opportunityService = opportunityService;
        this.opportunityRepository = opportunityRepository;
    }

    @GetMapping
    public List<Opportunity> getOpportunities(@CookieValue(name = "token", defaultValue = "") String token) {
        User user = userService.getUserByToken(token);
        if (user == null) return null;
        return opportunityService.findOpportunitiesByUser(user);
    }

    @PostMapping("new")
    public ResponseEntity<Opportunity> newOpportunity(
            HttpServletResponse response,
            @RequestBody Opportunity opportunity) {
        opportunityRepository.saveAndFlush(opportunity);
        return new ResponseEntity<>(opportunity, HttpStatus.CREATED);
    }
}
