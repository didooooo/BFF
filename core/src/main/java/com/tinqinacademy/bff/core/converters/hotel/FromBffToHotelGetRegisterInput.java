package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.getRegister.GetRegisterInputBFF;
import com.tinqinacademy.hotel.api.models.operations.getRegister.GetRegisterInput;
import org.springframework.core.convert.converter.Converter;

public class FromBffToHotelGetRegisterInput implements Converter<GetRegisterInputBFF, GetRegisterInput> {
    @Override
    public GetRegisterInput convert(GetRegisterInputBFF source) {
        return GetRegisterInput.builder()
                .birthdate(source.getBirthdate())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .phoneNo(source.getPhoneNo())
                .authority(source.getAuthority())
                .endDate(source.getEndDate())
                .startDate(source.getStartDate())
                .date(source.getDate())
                .IDCardNumber(source.getIDCardNumber())
                .roomNo(source.getRoomNo())
                .validity(source.getValidity())
                .build();
    }
}
