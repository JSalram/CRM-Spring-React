package com.solera.crm.service;

import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityService {

    private final OpportunityRepository repo;

    @Autowired
    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.repo = opportunityRepository;
    }

    public List<Opportunity> findOpportunitiesByUser(User user) {
        return repo.findAll();
    }
}
