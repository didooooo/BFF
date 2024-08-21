package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.systemRoom.SystemRoomInputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemRoom.SystemRoomInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelSystemRoom implements Converter<SystemRoomInputBFF, SystemRoomInput> {
    @Override
    public SystemRoomInput convert(SystemRoomInputBFF source) {
        return SystemRoomInput.builder()
                .roomNo(source.getRoomNo())
                .beds(source.getBeds())
                .bathroomType(source.getBathroomType())
                .floor(source.getFloor())
                .price(source.getPrice())
                .build();
    }
}
