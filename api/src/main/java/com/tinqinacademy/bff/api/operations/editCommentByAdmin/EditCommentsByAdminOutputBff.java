package com.tinqinacademy.bff.api.operations.editCommentByAdmin;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EditCommentsByAdminOutputBff implements OperationOutput {
    private String id;
}
