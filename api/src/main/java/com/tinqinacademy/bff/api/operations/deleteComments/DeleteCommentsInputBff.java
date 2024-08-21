package com.tinqinacademy.bff.api.operations.deleteComments;

import com.tinqinacademy.bff.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeleteCommentsInputBff implements OperationInput {
    private String commentId;
}
