package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.getRoomById.GetRoomByIDInputBFF;
import com.tinqinacademy.hotel.api.models.operations.getRoomById.GetRoomByIDInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelGetRoomByIdInput implements Converter<GetRoomByIDInputBFF, GetRoomByIDInput> {
    @Override
    public GetRoomByIDInput convert(GetRoomByIDInputBFF source) {
        return GetRoomByIDInput.builder()
                .roomId(source.getRoomId())
                .build();
    }
}
