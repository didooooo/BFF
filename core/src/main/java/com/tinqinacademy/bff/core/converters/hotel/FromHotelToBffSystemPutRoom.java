package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.systemPut.SystemPutRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemPut.SystemPutRoomOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromHotelToBffSystemPutRoom implements Converter<SystemPutRoomOutput, SystemPutRoomOutputBFF> {
    @Override
    public SystemPutRoomOutputBFF convert(SystemPutRoomOutput source) {
        return SystemPutRoomOutputBFF.builder()
                .id(source.getId())
                .build();
    }
}
