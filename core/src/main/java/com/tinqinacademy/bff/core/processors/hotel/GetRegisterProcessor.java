package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.getRegister.GetRegisterInputBFF;
import com.tinqinacademy.bff.api.operations.getRegister.GetRegisterOperation;
import com.tinqinacademy.bff.api.operations.getRegister.GetRegisterOutputBFF;
import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.hotel.api.models.operations.getRegister.GetRegisterInput;
import com.tinqinacademy.hotel.api.models.operations.getRegister.GetRegisterOutput;
import com.tinqinacademy.hotel.restexport.RestExportHotel;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetRegisterProcessor implements GetRegisterOperation {
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;
    private final RestExportHotel restExportHotel;


    public GetRegisterProcessor(ErrorMapper errorMapper,
                                ConversionService conversionService,
                                RestExportHotel restExportHotel) {
        this.errorMapper = errorMapper;
        this.conversionService = conversionService;
        this.restExportHotel = restExportHotel;
    }

    @Override
    public Either<Errors, GetRegisterOutputBFF> process(GetRegisterInputBFF input) {
        return Try.of(() -> {
                    GetRegisterInput convert = conversionService.convert(input, GetRegisterInput.class);
                    GetRegisterOutput register = restExportHotel.register(convert.getStartDate(),
                            convert.getEndDate(), convert.getRoomNo(),
                            convert.getFirstName(), convert.getLastName(),
                            convert.getPhoneNo(), convert.getIDCardNumber(),
                            convert.getValidity(), convert.getAuthority(), convert.getDate());
                    GetRegisterOutputBFF result = conversionService.convert(register,GetRegisterOutputBFF.class);
                    return result;
                }).toEither()
                .mapLeft(throwable -> errorMapper.mapError(throwable));
    }
}
