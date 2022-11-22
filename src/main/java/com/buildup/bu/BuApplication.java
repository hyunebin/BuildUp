package com.buildup.bu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BuApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuApplication.class, args);
    }

}
