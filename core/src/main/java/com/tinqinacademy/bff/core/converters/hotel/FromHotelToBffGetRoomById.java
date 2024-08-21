package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.enums.BathroomType;
import com.tinqinacademy.bff.api.operations.getRoomById.GetRoomByIDOutputBFF;
import com.tinqinacademy.hotel.api.models.enums.Bed;
import com.tinqinacademy.hotel.api.models.operations.getRoomById.GetRoomByIDOutput;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FromHotelToBffGetRoomById implements Converter<GetRoomByIDOutput, GetRoomByIDOutputBFF> {
    private final ConversionService conversionService;
    @Override
    public GetRoomByIDOutputBFF convert(GetRoomByIDOutput source) {
        List<com.tinqinacademy.bff.api.enums.Bed> beds = getBeds(source);

        return GetRoomByIDOutputBFF.builder()
                .id(source.getId())
                .price(source.getPrice())
                .floor(source.getFloor())
                .bathroomType(conversionService.convert(source.getBathroomType(), BathroomType.class))
                .datesOccupied(source.getDatesOccupied())
                .beds(beds)
                .build();
    }

    private @NotNull List<com.tinqinacademy.bff.api.enums.Bed> getBeds(GetRoomByIDOutput source) {
        List<com.tinqinacademy.bff.api.enums.Bed> beds = new ArrayList<>();
        for (Bed bed : source.getBeds()) {
            beds.add(com.tinqinacademy.bff.api.enums.Bed.getByCode(bed.toString()));
        }
        return beds;
    }
}
