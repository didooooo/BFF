package com.tinqinacademy.bff.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages = {"com.tinqinacademy.bff"})
@EnableFeignClients(basePackages = "com.tinqinacademy.bff.domain.configurations")
//@ComponentScan(basePackages = "com.tinqinacademy.bff")
public class BffApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffApplication.class, args);
    }

}
