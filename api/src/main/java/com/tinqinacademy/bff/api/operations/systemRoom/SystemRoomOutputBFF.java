package com.tinqinacademy.bff.api.operations.systemRoom;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SystemRoomOutputBFF implements OperationOutput {
    private UUID id;
}
