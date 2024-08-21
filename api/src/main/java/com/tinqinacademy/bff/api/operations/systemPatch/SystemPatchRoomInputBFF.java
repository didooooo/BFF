package com.tinqinacademy.bff.api.operations.systemPatch;

import com.tinqinacademy.bff.api.base.OperationInput;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SystemPatchRoomInputBFF implements OperationInput {
    @Hidden
    private String id;
    private List<String> beds;
    @NotBlank
    private String bathroomType;
    private String roomNumber;
    private BigDecimal price;
}
