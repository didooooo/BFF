package com.tinqinacademy.bff.api.operations.systemDelete;

import com.tinqinacademy.bff.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SystemDeleteRoomInputBFF implements OperationInput {
    private String id;
}
