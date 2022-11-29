package com.solera.crm.config;

import com.solera.crm.entity.Contact;
import com.solera.crm.entity.Opportunity;
import com.solera.crm.repository.OpportunityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Configuration
public class OpportunityConfig {

    @Bean
    CommandLineRunner opportunityCommandLineRunner(OpportunityRepository opportunityRepository) {
        return args -> {
            Opportunity op = new Opportunity(
                    false,
                    null
            );
            op.addContact(
                    new Contact(
                            new Date(),
                            "visit",
                            false,
                            null
                    )
            );
            opportunityRepository.saveAll(List.of(op));
        };
    }
}
