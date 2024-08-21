package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.unbookRoom.UnbookRoomByIdInputBFF;
import com.tinqinacademy.hotel.api.models.operations.unbookRoom.UnbookRoomByIdInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelUnbookRoomById implements Converter<UnbookRoomByIdInputBFF, UnbookRoomByIdInput> {
    @Override
    public UnbookRoomByIdInput convert(UnbookRoomByIdInputBFF source) {
        return UnbookRoomByIdInput.builder()
                .bookingId(source.getBookingId())
                .build();
    }
}
