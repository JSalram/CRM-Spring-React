package com.solera.crm.config;

import com.solera.crm.entity.User;
import com.solera.crm.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository) {
        return args -> {
            List<User> users = List.of(new User(
                    "admin",
                    "21232f297a57a5a743894a0e4a801fc3"
            ), new User(
                    "user",
                    "ee11cbb19052e40b07aac0ca060c23ee"
            ));

            userRepository.saveAll(users);
        };
    }
}
