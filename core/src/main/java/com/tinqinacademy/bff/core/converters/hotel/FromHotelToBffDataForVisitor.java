package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.hotel.api.models.operations.registerVisitor.DataForVisitor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromHotelToBffDataForVisitor implements Converter<DataForVisitor, com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor> {
    @Override
    public com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor convert(DataForVisitor source) {
        return com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor.builder()
                .authority(source.getAuthority())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .birthdate(source.getBirthdate())
                .IDCardNumber(source.getIDCardNumber())
                .issueDate(source.getIssueDate())
                .phoneNo(source.getPhoneNo())
                .validity(source.getValidity())
                .build();
    }
}
