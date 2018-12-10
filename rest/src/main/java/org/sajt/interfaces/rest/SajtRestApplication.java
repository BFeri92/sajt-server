package org.sajt.interfaces.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.sajt")
public class SajtRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SajtRestApplication.class, args);
    }
}
