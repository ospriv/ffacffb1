package com.ospriv.greencode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ospriv.greencode"})
public class GreenCodeApp {
    public static void main(String[] args) {
        SpringApplication.run(GreenCodeApp.class, args);
    }
}
