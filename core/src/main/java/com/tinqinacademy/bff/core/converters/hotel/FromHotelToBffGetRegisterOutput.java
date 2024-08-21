package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.getRegister.GetRegisterOutputBFF;
import com.tinqinacademy.hotel.api.models.operations.getRegister.GetRegisterOutput;
import com.tinqinacademy.hotel.api.models.operations.registerVisitor.DataForVisitor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FromHotelToBffGetRegisterOutput implements Converter<GetRegisterOutput, GetRegisterOutputBFF> {
    private final ConversionService conversionService;

    public FromHotelToBffGetRegisterOutput(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public GetRegisterOutputBFF convert(GetRegisterOutput source) {
        List<com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor> data = getDataForVisitors(source);
        return GetRegisterOutputBFF.builder()
                .data(data)
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .build();
    }

    private List<com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor> getDataForVisitors(GetRegisterOutput source) {
        List<com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor> data = new ArrayList<>();
        for (DataForVisitor datum : source.getData()) {
            data.add(conversionService.convert(datum, com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor.class));
        }
        return data;
    }
}
