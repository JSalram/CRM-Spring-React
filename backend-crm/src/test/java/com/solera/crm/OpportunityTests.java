package com.solera.crm;

import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.service.OpportunityService;
import com.solera.crm.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class OpportunityTests {

    @Autowired
    private UserService userService;
    @Autowired
    private OpportunityService opportunityService;

    @Test
    void findOpportunitiesByUser_full() {
        User user = getUser("admin", "admin");
        List<Opportunity> opportunityList = opportunityService.findOpportunitiesByUser(user);
        Assertions.assertFalse(opportunityList.isEmpty());
    }

    @Test
    void findOpportunitiesByUser_empty() {
        User user = getUser("user", "user");
        List<Opportunity> opportunityList = opportunityService.findOpportunitiesByUser(user);
        Assertions.assertTrue(opportunityList.isEmpty());
    }

    private User getUser(String username, String password) {
        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);
        return userService.getUser(data);
    }
}
