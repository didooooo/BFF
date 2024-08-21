package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.systemPatch.SystemPatchRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemPatch.SystemPatchRoomOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromHotelToBffSystemPatch implements Converter<SystemPatchRoomOutput, SystemPatchRoomOutputBFF> {
    @Override
    public SystemPatchRoomOutputBFF convert(SystemPatchRoomOutput source) {
        return SystemPatchRoomOutputBFF.builder()
                .id(source.getId())
                .build();
    }
}
