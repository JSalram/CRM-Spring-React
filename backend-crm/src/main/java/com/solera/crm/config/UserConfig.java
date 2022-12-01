package com.solera.crm.config;

import com.solera.crm.entity.Contact;
import com.solera.crm.entity.Opportunity;
import com.solera.crm.entity.User;
import com.solera.crm.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository) {
        return args -> {
            User u1 = new User(
                    "admin",
                    "21232f297a57a5a743894a0e4a801fc3",
                    User.ROLE_ADMIN
            );
            User u2 = new User(
                    "user",
                    "ee11cbb19052e40b07aac0ca060c23ee",
                    User.ROLE_USER
            );

            Opportunity op = new Opportunity(
                    "Juan",
                    "Dominguez",
                    "123456798",
                    false
            );
            op.addContact(
                    new Contact(
                            "Visita en casa de Juan",
                            new Date(),
                            "visit",
                            true
                    )
            );
            u1.addOpportunity(op);
            List<User> users = List.of(u1, u2);
            userRepository.saveAll(users);
        };
    }
}
