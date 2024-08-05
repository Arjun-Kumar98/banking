package com.example.kumar1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Kumar1Application {


    @GetMapping("/info")
    public String hello() {
        return "Hello World";
    }
    public static void main(String[] args) {
        SpringApplication.run(Kumar1Application.class , args);
    }

}
