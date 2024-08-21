package com.tinqinacademy.bff.api.operations.bookRoom;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookTheSpecificRoomOutputBFF implements OperationOutput {
    private String message;

}
