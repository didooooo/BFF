package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.enums.BathroomType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromHotelToBffBathroomType implements Converter<com.tinqinacademy.hotel.api.models.enums.BathroomType, BathroomType> {
    @Override
    public BathroomType convert(com.tinqinacademy.hotel.api.models.enums.BathroomType source) {
        return BathroomType.valueOf(source.getCode());
    }
}
