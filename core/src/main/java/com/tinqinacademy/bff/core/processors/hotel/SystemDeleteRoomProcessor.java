package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.systemDelete.SystemDeleteRoomInputBFF;
import com.tinqinacademy.bff.api.operations.systemDelete.SystemDeleteRoomOperation;
import com.tinqinacademy.bff.api.operations.systemDelete.SystemDeleteRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemDelete.SystemDeleteRoomInput;
import com.tinqinacademy.hotel.api.models.operations.systemDelete.SystemDeleteRoomOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class SystemDeleteRoomProcessor implements SystemDeleteRoomOperation {
    private final RestExportHotel restExportHotel;
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;

    public SystemDeleteRoomProcessor(RestExportHotel restExportHotel, ErrorMapper errorMapper, ConversionService conversionService) {
        this.restExportHotel = restExportHotel;
        this.errorMapper = errorMapper;
        this.conversionService = conversionService;
    }

    @Override
    public Either<Errors, SystemDeleteRoomOutputBFF> process(SystemDeleteRoomInputBFF input) {
        return Try.of(() -> {
                    SystemDeleteRoomInput convert = conversionService.convert(input, SystemDeleteRoomInput.class);
                    SystemDeleteRoomOutput output = restExportHotel.deleteRoom(convert.getId());
                    return conversionService.convert(output, SystemDeleteRoomOutputBFF.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
