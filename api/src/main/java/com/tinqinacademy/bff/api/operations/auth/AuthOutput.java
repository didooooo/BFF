package com.tinqinacademy.bff.api.operations.auth;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthOutput implements OperationOutput {
    private Boolean isJwtValid;
}