package com.tinqinacademy.bff.api.operations.systemPut;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SystemPutRoomOutputBFF implements OperationOutput {
    private String id;
}
