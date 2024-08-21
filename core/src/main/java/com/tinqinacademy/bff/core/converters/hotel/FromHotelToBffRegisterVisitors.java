package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.registerVisitor.RegisterVisitorOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.registerVisitor.RegisterVisitorOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromHotelToBffRegisterVisitors implements Converter<RegisterVisitorOutput, RegisterVisitorOutputBFF> {
    @Override
    public RegisterVisitorOutputBFF convert(RegisterVisitorOutput source) {
        return RegisterVisitorOutputBFF.builder()
                .message(source.getMessage())
                .build();
    }
}
