package com.example.NinjaProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NinjaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaProjectApplication.class, args);
    }

}
