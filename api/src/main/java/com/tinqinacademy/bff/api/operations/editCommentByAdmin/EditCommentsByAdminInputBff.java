package com.tinqinacademy.bff.api.operations.editCommentByAdmin;

import com.tinqinacademy.bff.api.base.OperationInput;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EditCommentsByAdminInputBff implements OperationInput {
    @Hidden
    private String commentId;
    @NotBlank
    private String roomNo;
    @NotBlank
    private String firstName;
    private String lastName;
    @NotBlank
    @Size(min = 20, max = 200)
    private String content;
}
