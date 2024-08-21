package com.tinqinacademy.bff.api.config;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.ErrorMappings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorMapperConfiguration {
    @Bean
    public ErrorMapper errorMapper(){
        return new ErrorMapper(new ErrorMappings());
    }
}
