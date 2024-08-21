package com.tinqinacademy.bff.api.operations.unbookRoom;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UnbookRoomByIdOutputBFF implements OperationOutput {
    private String message;
}
