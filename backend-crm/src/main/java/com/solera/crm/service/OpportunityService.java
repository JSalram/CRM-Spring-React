package com.solera.crm.service;

import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return opportunityRepository.findByUser(user);
    }
}
