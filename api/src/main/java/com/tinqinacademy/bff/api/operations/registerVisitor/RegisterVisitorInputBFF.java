package com.tinqinacademy.bff.api.operations.registerVisitor;

import com.tinqinacademy.bff.api.base.OperationInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegisterVisitorInputBFF implements OperationInput {
    @FutureOrPresent
    private LocalDate startDate;
    @FutureOrPresent(message = "can not be past")
    private LocalDate endDate;
    @NotBlank
    private String roomId;
    private List<@Valid DataForVisitor> dataForVisitors;
}
