package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.unbookRoom.UnbookRoomByIdOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.unbookRoom.UnbookRoomByIdOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromHotelToBffUnbookRoomById implements Converter<UnbookRoomByIdOutput, UnbookRoomByIdOutputBFF> {
    @Override
    public UnbookRoomByIdOutputBFF convert(UnbookRoomByIdOutput source) {
        return UnbookRoomByIdOutputBFF.builder()
                .message(source.getMessage())
                .build();
    }
}
