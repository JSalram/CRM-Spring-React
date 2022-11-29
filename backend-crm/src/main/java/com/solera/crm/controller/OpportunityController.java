package com.solera.crm.controller;

import com.solera.crm.entity.Opportunity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/opportunities")
public class OpportunityController {

    @GetMapping
    public String getOpportunities() {
        return "llll";
    }
}
