package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.systemPut.SystemPutRoomIdInputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemPut.SystemPutRoomIdInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelSystemPutRoom implements Converter<SystemPutRoomIdInputBFF, SystemPutRoomIdInput> {
    @Override
    public SystemPutRoomIdInput convert(SystemPutRoomIdInputBFF source) {
        return SystemPutRoomIdInput.builder()
                .roomId(source.getRoomId())
                .roomNo(source.getRoomNo())
                .beds(source.getBeds())
                .bathroomType(source.getBathroomType())
                .floor(source.getFloor())
                .price(source.getPrice())
                .build();
    }
}
