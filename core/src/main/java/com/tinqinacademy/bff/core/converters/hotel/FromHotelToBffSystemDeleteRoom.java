package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.systemDelete.SystemDeleteRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemDelete.SystemDeleteRoomOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromHotelToBffSystemDeleteRoom implements Converter<SystemDeleteRoomOutput, SystemDeleteRoomOutputBFF> {
    @Override
    public SystemDeleteRoomOutputBFF convert(SystemDeleteRoomOutput source) {
        return SystemDeleteRoomOutputBFF.builder()
                .message(source.getMessage())
                .build();
    }
}
