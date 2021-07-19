package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class CognizantChallengeApplication {

    Logger log = Logger.getLogger(CognizantChallengeApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(CognizantChallengeApplication.class, args);
    }

};