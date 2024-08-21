package com.tinqinacademy.bff.api.operations.bookRoom;

import com.tinqinacademy.bff.api.base.OperationInput;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookTheSpecificRoomInputBFF implements OperationInput {
    @Hidden
    private String roomId;
    private LocalDate startDate;
    @FutureOrPresent
    private LocalDate endDate;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNo;
    @Past
    private LocalDate birthdate;
    @Email
    private String email;
}
