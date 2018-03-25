package com.mygroupid.jar;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"com.mygroupid"})
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

}
