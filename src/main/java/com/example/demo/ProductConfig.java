package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner runner(ProductRepo productRepo) {
        return args -> {
            Product gucciShirt = new Apparel(
                    1L,
                    "Gucci Shirt",
                    1000F,
                    "Shirt",
                    "Gucci",
                    "Gucci"
            );
            Product countOfMonteCristo = new Book(
                    2L,
                    "The Count of Monte Cristo",
                    20F,
                    "Adventure",
                    "Alexandre Dumas",
                    1844
            );
            productRepo.saveAll(List.of(gucciShirt, countOfMonteCristo));
        };
    }
}
