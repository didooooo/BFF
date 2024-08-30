package com.tinqinacademy.bff.rest.controllers;


import com.tinqinacademy.bff.api.operations.bookRoom.BookTheSpecificRoomInputBFF;
import com.tinqinacademy.bff.api.operations.bookRoom.BookTheSpecificRoomOperation;
import com.tinqinacademy.hotel.api.models.mapping.URLMapping;
import com.tinqinacademy.hotel.api.models.operations.bookRoom.BookTheSpecificRoomInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController extends BaseController {
    private final BookTheSpecificRoomOperation bookTheSpecificRoomOperation;

    public HotelController(BookTheSpecificRoomOperation bookTheSpecificRoomOperation) {
        this.bookTheSpecificRoomOperation = bookTheSpecificRoomOperation;
    }
    @Operation(
            summary = "book a room",
            responses = {
                    @ApiResponse(responseCode = "200", description = "booked")
            }
    )
    @PostMapping(URLMapping.GET_ROOM_BY_ID)
    public ResponseEntity<?> bookSpecificRoom(@PathVariable("roomId") String roomId, @RequestBody BookTheSpecificRoomInputBFF input) {
        input.setRoomId(roomId);
        return super.handleTheEither(bookTheSpecificRoomOperation.process(input));
    }
}
