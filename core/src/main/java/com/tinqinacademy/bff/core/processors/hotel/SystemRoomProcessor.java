package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.systemRoom.SystemRoomInputBFF;
import com.tinqinacademy.bff.api.operations.systemRoom.SystemRoomOperation;
import com.tinqinacademy.bff.api.operations.systemRoom.SystemRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemRoom.SystemRoomInput;
import com.tinqinacademy.hotel.api.models.operations.systemRoom.SystemRoomOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class SystemRoomProcessor implements SystemRoomOperation {
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;
    private final RestExportHotel restExportHotel;

    public SystemRoomProcessor(ErrorMapper errorMapper, ConversionService conversionService, RestExportHotel restExportHotel) {
        this.errorMapper = errorMapper;
        this.conversionService = conversionService;
        this.restExportHotel = restExportHotel;
    }

    @Override
    public Either<Errors, SystemRoomOutputBFF> process(SystemRoomInputBFF input) {
        return Try.of(() -> {
                    SystemRoomInput convert = conversionService.convert(input, SystemRoomInput.class);
                    SystemRoomOutput systemRoomOutput = restExportHotel.postRoom(convert);
                    return conversionService.convert(systemRoomOutput, SystemRoomOutputBFF.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
