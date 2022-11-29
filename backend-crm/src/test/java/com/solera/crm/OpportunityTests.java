package com.solera.crm;

import com.solera.crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpportunityTests {

    private OpportunityService opportunityService;

    @Autowired
    public OpportunityTests(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }
}
