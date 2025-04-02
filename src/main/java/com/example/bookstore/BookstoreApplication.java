package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.bookstore.Entity")
@EnableJpaRepositories("com.example.bookstore.Repository")
public class BookstoreApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


    }
}
