package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.registerVisitor.RegisterVisitorInputBFF;
import com.tinqinacademy.bff.api.operations.registerVisitor.RegisterVisitorOperation;
import com.tinqinacademy.bff.api.operations.registerVisitor.RegisterVisitorOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.registerVisitor.RegisterVisitorInput;
import com.tinqinacademy.hotel.api.models.operations.registerVisitor.RegisterVisitorOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterVisitorProcessor implements RegisterVisitorOperation {
    private final ConversionService conversionService;
    private final ErrorMapper errorMapper;
    private final RestExportHotel restExportHotel;

    public RegisterVisitorProcessor(ConversionService conversionService, ErrorMapper errorMapper, RestExportHotel restExportHotel) {
        this.conversionService = conversionService;
        this.errorMapper = errorMapper;
        this.restExportHotel = restExportHotel;
    }

    @Override
    public Either<Errors, RegisterVisitorOutputBFF> process(RegisterVisitorInputBFF input) {
        return Try.of(() -> {
                    RegisterVisitorInput convert = conversionService.convert(input, RegisterVisitorInput.class);
                    RegisterVisitorOutput register = restExportHotel.register(convert);
                    return conversionService.convert(register,RegisterVisitorOutputBFF.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
