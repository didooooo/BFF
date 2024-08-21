package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.systemPatch.SystemPatchRoomInputBFF;
import com.tinqinacademy.bff.api.operations.systemPatch.SystemPatchRoomOperation;
import com.tinqinacademy.bff.api.operations.systemPatch.SystemPatchRoomOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.systemPatch.SystemPatchRoomInput;
import com.tinqinacademy.hotel.api.models.operations.systemPatch.SystemPatchRoomOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class SystemPatchRoomProcessor implements SystemPatchRoomOperation {
    private final RestExportHotel restExportHotel;
    private  final ConversionService conversionService;
    private final ErrorMapper errorMapper;

    public SystemPatchRoomProcessor(RestExportHotel restExportHotel, ConversionService conversionService, ErrorMapper errorMapper) {
        this.restExportHotel = restExportHotel;
        this.conversionService = conversionService;
        this.errorMapper = errorMapper;
    }

    @Override
    public Either<Errors, SystemPatchRoomOutputBFF> process(SystemPatchRoomInputBFF input) {
        return Try.of(()->{
                    SystemPatchRoomInput convert = conversionService.convert(input, SystemPatchRoomInput.class);
                    SystemPatchRoomOutput systemPatchRoomOutput = restExportHotel.patchRoom(convert.getId(), convert);
                    return conversionService.convert(systemPatchRoomOutput, SystemPatchRoomOutputBFF.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
