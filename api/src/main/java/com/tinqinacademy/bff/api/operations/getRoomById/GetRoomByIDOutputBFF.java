package com.tinqinacademy.bff.api.operations.getRoomById;

import com.tinqinacademy.bff.api.base.OperationOutput;
import com.tinqinacademy.bff.api.enums.BathroomType;
import com.tinqinacademy.bff.api.enums.Bed;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GetRoomByIDOutputBFF implements OperationOutput {
    private String id;
    private BigDecimal price;
    private Integer floor;
    private List<Bed> beds;
    private BathroomType bathroomType;
    private List<LocalDate> datesOccupied;

}
