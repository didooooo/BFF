package com.tinqinacademy.bff.api.operations.checkRoom;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CheckRoomAvailabilityOutputBFF implements OperationOutput {
    private List<String> ids;
}
