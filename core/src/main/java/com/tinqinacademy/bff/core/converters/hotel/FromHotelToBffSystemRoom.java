package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.systemRoom.SystemRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemRoom.SystemRoomOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromHotelToBffSystemRoom implements Converter<SystemRoomOutput, SystemRoomOutputBFF> {
    @Override
    public SystemRoomOutputBFF convert(SystemRoomOutput source) {
        return SystemRoomOutputBFF.builder()
                .id(source.getId())
                .build();
    }
}
