package com.eazybytes.eazystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.webmvc.autoconfigure.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//this is required if the controller is not there in package of main class @ComponentScan(basePackages = {"com.eazybytes.eazystore"})
@SpringBootApplication(/*exclude = ErrorMvcAutoConfiguration.class*/)
public class EazystoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazystoreApplication.class, args);
    }

}
