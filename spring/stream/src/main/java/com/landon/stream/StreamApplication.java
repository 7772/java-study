package com.landon.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamApplication.class, args);

        Service service = new Service();
        service.q1();
        service.q2();
        service.q3();
        service.q4();
        service.q5();
        service.q6();
        service.q7();
        service.q8();
    }

}
