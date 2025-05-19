package com.sports.fieldsmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class FieldsmanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FieldsmanagementsystemApplication.class, args);
    }

}
