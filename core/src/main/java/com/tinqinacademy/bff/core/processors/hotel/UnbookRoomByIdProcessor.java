package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.operations.unbookRoom.UnbookRoomByIdInputBFF;
import com.tinqinacademy.bff.api.operations.unbookRoom.UnbookRoomByIdOperation;
import com.tinqinacademy.bff.api.operations.unbookRoom.UnbookRoomByIdOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.unbookRoom.UnbookRoomByIdInput;
import com.tinqinacademy.hotel.api.models.operations.unbookRoom.UnbookRoomByIdOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UnbookRoomByIdProcessor implements UnbookRoomByIdOperation {
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;
    private final RestExportHotel restExportHotel;

//    public UnbookRoomByIdProcessor(ErrorMapper errorMapper, ConversionService conversionService, RestExportHotel restExportHotel) {
//        this.errorMapper = errorMapper;
//        this.conversionService = conversionService;
//        this.restExportHotel = restExportHotel;
//    }

    @Override
    public Either<com.tinqinacademy.bff.api.exceptions.Errors, UnbookRoomByIdOutputBFF> process(UnbookRoomByIdInputBFF input) {
        return Try.of(() -> {
                    UnbookRoomByIdInput convert = conversionService.convert(input, UnbookRoomByIdInput.class);
                    UnbookRoomByIdOutput unbookRoomByIdOutput = restExportHotel.unbookRoomById(convert.getBookingId());
                    return conversionService.convert(unbookRoomByIdOutput, UnbookRoomByIdOutputBFF.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
