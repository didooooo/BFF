package com.tinqinacademy.bff.api.operations.unbookRoom;

import com.tinqinacademy.bff.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UnbookRoomByIdInputBFF implements OperationInput {
    @NotBlank
    private String bookingId;
}
