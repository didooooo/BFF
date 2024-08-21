package com.tinqinacademy.bff.api.operations.systemDelete;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SystemDeleteRoomOutputBFF implements OperationOutput {
    private String message;
}
