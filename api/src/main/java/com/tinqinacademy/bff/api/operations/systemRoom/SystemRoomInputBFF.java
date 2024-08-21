package com.tinqinacademy.bff.api.operations.systemRoom;

import com.tinqinacademy.bff.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SystemRoomInputBFF implements OperationInput {
    private List<String> beds;
    @NotBlank
    private String bathroomType;
    @Positive
    private Integer floor;
    @NotBlank
    private String roomNo;
    @Positive
    private BigDecimal price;
}
