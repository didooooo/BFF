package com.tinqinacademy.bff.api.operations.systemPatch;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SystemPatchRoomOutputBFF implements OperationOutput {
    private String id;
}
