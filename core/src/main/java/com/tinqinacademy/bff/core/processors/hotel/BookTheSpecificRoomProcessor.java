package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.bookRoom.BookTheSpecificRoomInputBFF;
import com.tinqinacademy.bff.api.operations.bookRoom.BookTheSpecificRoomOperation;
import com.tinqinacademy.bff.api.operations.bookRoom.BookTheSpecificRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.bookRoom.BookTheSpecificRoomInput;
import com.tinqinacademy.hotel.api.models.operations.bookRoom.BookTheSpecificRoomOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookTheSpecificRoomProcessor implements BookTheSpecificRoomOperation {
    private final ErrorMapper errorMapper;
    private final RestExportHotel restExportHotel;
    private final ConversionService conversionService;

    public BookTheSpecificRoomProcessor(ErrorMapper errorMapper, RestExportHotel restExportHotel, ConversionService conversionService) {
        this.errorMapper = errorMapper;
        this.restExportHotel = restExportHotel;
        this.conversionService = conversionService;
    }

    @Override
    public Either<Errors, BookTheSpecificRoomOutputBFF> process(BookTheSpecificRoomInputBFF input) {
        return Try.of(() -> {
                    BookTheSpecificRoomInput convert = conversionService.convert(input, BookTheSpecificRoomInput.class);
                    BookTheSpecificRoomOutput bookTheSpecificRoomOutput = restExportHotel.bookSpecificRoom(input.getRoomId(), convert);
                    BookTheSpecificRoomOutputBFF result = conversionService.convert(bookTheSpecificRoomOutput, BookTheSpecificRoomOutputBFF.class);
                    return result;
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
