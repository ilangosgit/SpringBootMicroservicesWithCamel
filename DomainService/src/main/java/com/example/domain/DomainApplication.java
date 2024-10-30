package com.example.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")

public class DomainApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DomainApplication.class, args);
    }
    private static final Logger log = LoggerFactory.getLogger(DomainApplication.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("You can press Ctrl+C anytime to shutdown application");
        Thread.currentThread().join();
    }
}