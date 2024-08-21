package com.tinqinacademy.bff.api.operations.checkRoom;

import com.tinqinacademy.bff.api.base.OperationInput;
import com.tinqinacademy.bff.api.enums.BathroomType;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CheckRoomAvailabilityInputBFF implements OperationInput {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> beds;
    private BathroomType bathroomType;
}
