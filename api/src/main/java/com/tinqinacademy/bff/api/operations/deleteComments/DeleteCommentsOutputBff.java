package com.tinqinacademy.bff.api.operations.deleteComments;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeleteCommentsOutputBff implements OperationOutput {
    private String message;
}
