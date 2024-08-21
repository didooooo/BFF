package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.bookRoom.BookTheSpecificRoomInputBFF;
import com.tinqinacademy.hotel.api.models.operations.bookRoom.BookTheSpecificRoomInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToHotelBookTheSpecificRoom implements Converter<BookTheSpecificRoomInput, BookTheSpecificRoomInputBFF> {
    @Override
    public BookTheSpecificRoomInputBFF convert(BookTheSpecificRoomInput source) {
        return BookTheSpecificRoomInputBFF.builder()
                .roomId(source.getRoomId())
                .birthdate(source.getBirthdate())
                .email(source.getEmail())
                .endDate(source.getEndDate())
                .startDate(source.getStartDate())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .phoneNo(source.getPhoneNo())
                .build();
    }
}
