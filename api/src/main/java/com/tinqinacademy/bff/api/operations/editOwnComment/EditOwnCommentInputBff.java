package com.tinqinacademy.bff.api.operations.editOwnComment;

import com.tinqinacademy.bff.api.base.OperationInput;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EditOwnCommentInputBff implements OperationInput {
    @Hidden
    private UUID id;
    private String content;
}
