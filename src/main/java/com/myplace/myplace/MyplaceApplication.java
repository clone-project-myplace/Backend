package com.myplace.myplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyplaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyplaceApplication.class, args);
    }

}
