package com.tinqinacademy.bff.api.operations.leaveAComment;

import com.tinqinacademy.bff.api.base.OperationInput;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LeaveACommentInputBff implements OperationInput {
    @Hidden
    private String roomId;
    @NotBlank
    private String firstName;
    private String lastName;
    @Size(min = 20, max = 200)
    private String content;
    private LocalDate birthdate;

}
