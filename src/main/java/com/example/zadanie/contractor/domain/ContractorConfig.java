package com.example.zadanie.contractor.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class ContractorConfig {

    @Bean
    CommandLineRunner commandLineRunner(ContractorRepository repository) {
        return args -> {
            Contractor andrzej = new Contractor(
                    1,
                    "Dupa",
                    "Andrzej",
                    "Adres",
                    "kod",
                    "Miasto",
                    "Kraj",
                    LocalDateTime.of(2020, 05, 03, 12, 12 ),
                    LocalDateTime.of(2020, 05, 03, 12, 12 )
            );

            Contractor waldek = new Contractor(
                    2,
                    "Dupa",
                    "Waldek",
                    "Adres",
                    "41-221",
                    "Miejsce",
                    "Ciekawe",
                    LocalDateTime.of(2020, 05, 03, 12, 12),
                    LocalDateTime.of(2020, 05, 03, 12, 12, 14)
            );
            repository.save(andrzej);
            repository.save(waldek);
        };
    }
}
