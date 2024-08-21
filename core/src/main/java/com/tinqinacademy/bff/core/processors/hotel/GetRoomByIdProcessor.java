package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.getRoomById.GetRoomByIDInputBFF;
import com.tinqinacademy.bff.api.operations.getRoomById.GetRoomByIDOutputBFF;
import com.tinqinacademy.bff.api.operations.getRoomById.GetRoomByIdOperation;
import com.tinqinacademy.hotel.api.models.operations.getRoomById.GetRoomByIDInput;
import com.tinqinacademy.hotel.api.models.operations.getRoomById.GetRoomByIDOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetRoomByIdProcessor implements GetRoomByIdOperation {
    private final RestExportHotel restExportHotel;
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;

    public GetRoomByIdProcessor(RestExportHotel restExportHotel, ErrorMapper errorMapper, ConversionService conversionService) {
        this.restExportHotel = restExportHotel;
        this.errorMapper = errorMapper;
        this.conversionService = conversionService;
    }

    @Override
    public Either<Errors, GetRoomByIDOutputBFF> process(GetRoomByIDInputBFF input) {
        return Try.of(() -> {
                    GetRoomByIDInput convert = conversionService.convert(input, GetRoomByIDInput.class);
                    GetRoomByIDOutput output = restExportHotel.getRoomByIDOutput(convert.getRoomId());
                    return conversionService.convert(output,GetRoomByIDOutputBFF.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
