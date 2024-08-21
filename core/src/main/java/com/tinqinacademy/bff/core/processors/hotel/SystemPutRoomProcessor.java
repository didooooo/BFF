package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.systemPut.SystemPutRoomIdInputBFF;
import com.tinqinacademy.bff.api.operations.systemPut.SystemPutRoomOperation;
import com.tinqinacademy.bff.api.operations.systemPut.SystemPutRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemPut.SystemPutRoomIdInput;
import com.tinqinacademy.hotel.api.models.operations.systemPut.SystemPutRoomOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class SystemPutRoomProcessor implements SystemPutRoomOperation {
    private final ConversionService conversionService;
    private final ErrorMapper errorMapper;
    private final RestExportHotel restExportHotel;

    public SystemPutRoomProcessor(ConversionService conversionService, ErrorMapper errorMapper, RestExportHotel restExportHotel) {
        this.conversionService = conversionService;
        this.errorMapper = errorMapper;
        this.restExportHotel = restExportHotel;
    }

    @Override
    public Either<Errors, SystemPutRoomOutputBFF> process(SystemPutRoomIdInputBFF input) {
        return Try.of(() -> {
                    SystemPutRoomIdInput convert = conversionService.convert(input, SystemPutRoomIdInput.class);
                    SystemPutRoomOutput output = restExportHotel.putRoom(String.valueOf(input.getRoomId()), convert);
                    return conversionService.convert(output,SystemPutRoomOutputBFF.class);

                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
