package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.systemDelete.SystemDeleteRoomInputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemDelete.SystemDeleteRoomInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelSystemDeleteRoom implements Converter<SystemDeleteRoomInputBFF, SystemDeleteRoomInput> {
    @Override
    public SystemDeleteRoomInput convert(SystemDeleteRoomInputBFF source) {
        return SystemDeleteRoomInput.builder()
                .id(source.getId())
                .build();
    }
}
