package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.checkRoom.CheckRoomAvailabilityOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.checkRoom.CheckRoomAvailabilityOutput;
import org.springframework.core.convert.converter.Converter;

public class FromHotelToBffCheckRoomAvailabilityOutput implements Converter<CheckRoomAvailabilityOutput, CheckRoomAvailabilityOutputBFF> {
    @Override
    public CheckRoomAvailabilityOutputBFF convert(CheckRoomAvailabilityOutput source) {
        return CheckRoomAvailabilityOutputBFF.builder()
                .ids(source.getIds())
                .build();
    }
}
