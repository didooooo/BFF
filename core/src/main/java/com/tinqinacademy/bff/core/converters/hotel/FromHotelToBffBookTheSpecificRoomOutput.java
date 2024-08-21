package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.bookRoom.BookTheSpecificRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.bookRoom.BookTheSpecificRoomOutput;
import org.springframework.core.convert.converter.Converter;

public class FromHotelToBffBookTheSpecificRoomOutput implements Converter<BookTheSpecificRoomOutput, BookTheSpecificRoomOutputBFF> {
    @Override
    public BookTheSpecificRoomOutputBFF convert(BookTheSpecificRoomOutput source) {
        return BookTheSpecificRoomOutputBFF
                .builder()
                .message(source.getMessage())
                .build();
    }
}
