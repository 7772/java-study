package com.dayspring.spring6restclients;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring6RestClientsApplication {

    @Bean
    ApplicationRunner applicationRunner(ExchangeApi exchangeApi) {
        return args -> {
            System.out.println("Hello!");

            String result = exchangeApi.getLatest();
            System.out.println(result);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Spring6RestClientsApplication.class, args);
    }

}
