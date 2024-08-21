package com.tinqinacademy.bff.api.operations.getRoomById;

import com.tinqinacademy.bff.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GetRoomByIDInputBFF implements OperationInput {
    private String roomId;
}
