package com.tinqinacademy.bff.api.operations.getRegister;

import com.tinqinacademy.bff.api.base.OperationOutput;
import com.tinqinacademy.bff.api.operations.registerVisitor.DataForVisitor;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GetRegisterOutputBFF implements OperationOutput {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<DataForVisitor> data;
}
