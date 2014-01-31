package com.cbaeza.frontend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * User: cbaeza
 * Since: 31.01.14
 */
@ComponentScan(basePackages = "com.cbaeza.frontend.controllers" )
@EnableAutoConfiguration
public class FrontEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontEndApplication.class, args);
    }

}
