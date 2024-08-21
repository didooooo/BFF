package com.tinqinacademy.bff.api.operations.editOwnComment;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EditOwnCommentOutputBff implements OperationOutput {
    private String id;
}
