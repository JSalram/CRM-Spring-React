package com.solera.crm.controller;

import com.solera.crm.entity.Client;
import com.solera.crm.entity.Contact;
import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.repository.OpportunityRepository;
import com.solera.crm.service.OpportunityService;
import com.solera.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/opportunities")
public class OpportunityController {

    @Autowired
    private UserService userService;
    @Autowired
    private OpportunityService opportunityService;
    @Autowired
    private OpportunityRepository opportunityRepository;

    @GetMapping
    public ResponseEntity<List<Opportunity>> getOpportunities(@CookieValue(name = "token", defaultValue = "") String token) {
        if (userService.unauthorizedUser(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        User user = userService.getUserByToken(token);
        if (user == null) return null;
        List<Opportunity> opportunities = opportunityService.findOpportunitiesByUser(user);
        return new ResponseEntity<>(opportunities, HttpStatus.OK);
    }

    @PostMapping("new")
    public ResponseEntity<Opportunity> newOpportunity(
            @CookieValue(name = "token", defaultValue = "") String token,
            @RequestBody Opportunity opportunity
    ) {
        if (userService.unauthorizedUser(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        User user = userService.getUserByToken(token);
        opportunity.setUser(user);
        opportunityRepository.saveAndFlush(opportunity);
        return new ResponseEntity<>(opportunity, HttpStatus.CREATED);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<Opportunity> removeOpportunity(
            @CookieValue(name = "token", defaultValue = "") String token,
            @PathVariable(name = "id") Long id
    ) {
        if (userService.unauthorizedUser(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Optional<Opportunity> opportunity = opportunityRepository.findById(id);
        if (opportunity.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        opportunity.get().setActive(false);
        opportunityRepository.flush();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("client/{id}")
    public ResponseEntity<Client> setClient(
            @CookieValue(name = "token", defaultValue = "") String token,
            @PathVariable(name = "id") Long id
    ) {
        if (userService.unauthorizedUser(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Optional<Opportunity> opportunity = opportunityRepository.findById(id);
        if (opportunity.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        opportunity.get().setClient(new Client());
        opportunityRepository.flush();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("{id}/new")
    public ResponseEntity<Contact> addContact(
            @CookieValue(name = "token", defaultValue = "") String token,
            @PathVariable(name = "id") Long id,
            @RequestBody Contact contact
    ) {
        if (userService.unauthorizedUser(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (opportunityRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Opportunity opportunity = opportunityRepository.findById(id).get();
        opportunity.addContact(contact);
        opportunityRepository.flush();
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }
}
