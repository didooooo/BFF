package com.tinqinacademy.bff.domain;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "hotel", url = "http://localhost:8081")
public interface HotelService {

}
