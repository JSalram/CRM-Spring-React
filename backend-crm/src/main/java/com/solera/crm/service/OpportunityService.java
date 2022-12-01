package com.solera.crm.service;

import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OpportunityService {

    @Autowired
    private final OpportunityRepository opportunityRepository;

    @Autowired
    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public List<Opportunity> findOpportunitiesByUser(User user) {
        List<Opportunity> opportunities = opportunityRepository.findByUser(user);
        System.out.println(Arrays.toString(opportunities.toArray()));
        return opportunityRepository.findByUser(user);
    }
}
