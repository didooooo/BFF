package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor;
import com.tinqinacademy.bff.api.operations.registerVisitor.RegisterVisitorInputBFF;
import com.tinqinacademy.hotel.api.models.operations.registerVisitor.RegisterVisitorInput;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FromBffToHotelRegisterVisitor implements Converter<RegisterVisitorInputBFF, RegisterVisitorInput> {
    @Override
    public RegisterVisitorInput convert(RegisterVisitorInputBFF source) {
        List<com.tinqinacademy.hotel.api.models.operations.registerVisitor.DataForVisitor> data = getDataForVisitors(source);
        return RegisterVisitorInput.builder()
                .roomId(source.getRoomId())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .dataForVisitors(data).build();
    }

    private @NotNull List<com.tinqinacademy.hotel.api.models.operations.registerVisitor.DataForVisitor> getDataForVisitors(RegisterVisitorInputBFF source) {
        List<com.tinqinacademy.hotel.api.models.operations.registerVisitor.DataForVisitor> data = new ArrayList<>();
        for (DataForVisitor dataForVisitor : source.getDataForVisitors()) {
            data.add(
                    com.tinqinacademy.hotel.api.models.operations.registerVisitor.DataForVisitor.builder()
                            .phoneNo(dataForVisitor.getPhoneNo())
                            .validity(dataForVisitor.getValidity())
                            .issueDate(dataForVisitor.getIssueDate())
                            .birthdate(dataForVisitor.getBirthdate())
                            .firstName(dataForVisitor.getFirstName())
                            .lastName(dataForVisitor.getLastName())
                            .IDCardNumber(dataForVisitor.getIDCardNumber())
                            .authority(dataForVisitor.getAuthority())
                            .build()
            );
        }
        return data;
    }
}
