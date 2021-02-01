package com.baeldung;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {

            Stream.of("Rohit", "Radha", "Rachana", "Raayusha").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@yahoo.com");

            });
            userRepository.findAll().forEach(System.out::println);
        };

    }
}
