package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.enums.BathroomType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelBathroomType implements Converter<BathroomType, com.tinqinacademy.hotel.api.models.enums.BathroomType> {
    @Override
    public com.tinqinacademy.hotel.api.models.enums.BathroomType convert(BathroomType source) {
        return com.tinqinacademy.hotel.api.models.enums.BathroomType.valueOf(source.getCode());
    }
}
