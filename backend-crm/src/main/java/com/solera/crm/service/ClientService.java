package com.solera.crm.service;

import com.solera.crm.entity.Client;
import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private OpportunityService opportunityService;

    public List<Client> findClientsByUser(User user) {
        List<Client> clientList = new LinkedList<>();
        for (Opportunity op : opportunityService.findOpportunitiesByUser(user)) {
            if (op.getClient() != null && !clientList.contains(op.getClient())) {
                clientList.add(op.getClient());
            }
        }
        return clientList;
    }

}
