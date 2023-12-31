package com.tj.edu.practice5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JpaTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaTestApplication.class, args);
    }

}
