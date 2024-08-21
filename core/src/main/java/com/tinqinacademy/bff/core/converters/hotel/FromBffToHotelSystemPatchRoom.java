package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.systemPatch.SystemPatchRoomInputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemPatch.SystemPatchRoomInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelSystemPatchRoom implements Converter<SystemPatchRoomInputBFF, SystemPatchRoomInput> {
    @Override
    public SystemPatchRoomInput convert(SystemPatchRoomInputBFF source) {
        return SystemPatchRoomInput.builder()
                .id(source.getId())
                .bathroomType(source.getBathroomType())
                .beds(source.getBeds())
                .roomNumber(source.getRoomNumber())
                .price(source.getPrice())
                .build();
    }
}
