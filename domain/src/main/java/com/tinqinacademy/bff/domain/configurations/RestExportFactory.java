package com.tinqinacademy.bff.domain.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.authentication.restexport.RestExportAuthentication;
import com.tinqinacademy.comments.restexport.RestExportComments;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestExportFactory {
    @Bean
    RestExportComments getRestExportComments(){
        ObjectMapper objectMapper = new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(RestExportComments.class,"http://comments:8080");
    }
    @Bean
    RestExportHotel getRestExportHotel(){
        ObjectMapper objectMapper = new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(RestExportHotel.class,"http://hotel:8081");
    }
    @Bean
    RestExportAuthentication getRestExportAuthentication(){
        ObjectMapper objectMapper = new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(RestExportAuthentication.class,"http://authentication:8081");
    }
}
