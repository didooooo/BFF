package com.tinqinacademy.bff.domain.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.authentication.restexport.RestExportAuthentication;
import com.tinqinacademy.comments.restexport.RestExportComments;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RestExportFactory {
    private final ApplicationContext applicationContext;

    @Bean
    RestExportComments getRestExportComments() {
        ObjectMapper objectMapper = new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(applicationContext.getBean(ObjectMapper.class)))
                .decoder(new JacksonDecoder(applicationContext.getBean(ObjectMapper.class)))
                .target(RestExportComments.class, "http://localhost:8081/");
    }

    @Bean
    RestExportHotel getRestExportHotel() {
        ObjectMapper objectMapper = new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(applicationContext.getBean(ObjectMapper.class)))
                .decoder(new JacksonDecoder(applicationContext.getBean(ObjectMapper.class)))
                .target(RestExportHotel.class, "http://localhost:8080/");
    }

    @Bean
    RestExportAuthentication getRestExportAuthentication() {
        ObjectMapper objectMapper = new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(applicationContext.getBean(ObjectMapper.class)))
                .decoder(new JacksonDecoder(applicationContext.getBean(ObjectMapper.class)))
                .target(RestExportAuthentication.class, "http://localhost:8084/");
    }
//    @Bean
//    public RestExportHotel getRestExportHotel() {
//        RestExportHotel fooClient = Feign.builder()
////                .client(RibbonClient.create())
//                .client(new OkHttpClient())
//                .encoder(new GsonEncoder())
//                .decoder(new GsonDecoder())
//                .logger(new Slf4jLogger(RestExportHotel.class))
//                .logLevel(Logger.Level.FULL)
//                .target(RestExportHotel.class, "http://hotel:8080");
//        return fooClient;
//    }

}
