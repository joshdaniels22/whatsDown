package com.example.application.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import java.util.List;

import static java.time.Month.*;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository studentRepository) {
        return args -> {

            Person josh = new Person(
                    "Josh",
                    "Daniels",
                    LocalDate.of(2004, JANUARY, 5)
            );

            Person karen = new Person(
                    "Karen",
                    "Daniels",
                    LocalDate.of(2000, JANUARY, 5)
            );

            studentRepository.saveAll(List.of(josh,karen));
        };
    }
}
