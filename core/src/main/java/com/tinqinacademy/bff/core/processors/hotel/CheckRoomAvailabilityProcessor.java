package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.checkRoom.CheckRoomAvailabilityInputBFF;
import com.tinqinacademy.bff.api.operations.checkRoom.CheckRoomAvailabilityOperation;
import com.tinqinacademy.bff.api.operations.checkRoom.CheckRoomAvailabilityOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.checkRoom.CheckRoomAvailabilityInput;
import com.tinqinacademy.hotel.api.models.operations.checkRoom.CheckRoomAvailabilityOutput;
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
public class CheckRoomAvailabilityProcessor implements CheckRoomAvailabilityOperation {
    private final RestExportHotel restExportHotel;
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;
    @Override
    public Either<Errors, CheckRoomAvailabilityOutputBFF> process(CheckRoomAvailabilityInputBFF input) {
        return Try.of(() -> {
                    CheckRoomAvailabilityInput convert = conversionService.convert(input, CheckRoomAvailabilityInput.class);
                    CheckRoomAvailabilityOutput checkRoomAvailabilityOutput = restExportHotel.checkRoomAvailability(convert.getStartDate(), convert.getEndDate(), convert.getBeds(), String.valueOf(convert.getBathroomType()));
                    CheckRoomAvailabilityOutputBFF result = conversionService.convert(checkRoomAvailabilityOutput, CheckRoomAvailabilityOutputBFF.class);
                    return result;
                }).toEither()
                .mapLeft(throwable -> errorMapper.mapError(throwable));
    }

}
