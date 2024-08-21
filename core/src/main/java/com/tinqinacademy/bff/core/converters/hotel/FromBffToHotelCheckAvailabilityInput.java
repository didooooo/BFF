package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.checkRoom.CheckRoomAvailabilityInputBFF;
import com.tinqinacademy.hotel.api.models.enums.BathroomType;
import com.tinqinacademy.hotel.api.models.operations.checkRoom.CheckRoomAvailabilityInput;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelCheckAvailabilityInput implements Converter<CheckRoomAvailabilityInputBFF,CheckRoomAvailabilityInput> {
   private final ConversionService conversionService;

    public FromBffToHotelCheckAvailabilityInput(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public CheckRoomAvailabilityInput convert(CheckRoomAvailabilityInputBFF source) {
        return CheckRoomAvailabilityInput.builder()
                .endDate(source.getEndDate())
                .startDate(source.getStartDate())
                .bathroomType(conversionService.convert(source.getBathroomType(), BathroomType.class))
                .beds(source.getBeds())
                .build();
    }
}
