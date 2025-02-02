package com.tinqinacademy.bff.api.operations.getRegister;

import com.tinqinacademy.bff.api.base.OperationInput;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GetRegisterInputBFF implements OperationInput {
    private LocalDate startDate;
    private LocalDate endDate;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String IDCardNumber;
    private String validity;
    private String authority;
    private String date;
    private String birthdate;
    private String roomNo;
}
