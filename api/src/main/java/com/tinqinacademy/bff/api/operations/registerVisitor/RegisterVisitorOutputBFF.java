package com.tinqinacademy.bff.api.operations.registerVisitor;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegisterVisitorOutputBFF implements OperationOutput {
    private String message;
}
