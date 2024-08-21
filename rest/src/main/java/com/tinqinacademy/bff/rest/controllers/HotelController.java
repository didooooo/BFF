package com.tinqinacademy.bff.rest.controllers;


import com.tinqinacademy.bff.api.operations.bookRoom.BookTheSpecificRoomOperation;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController extends BaseController {
    private final BookTheSpecificRoomOperation bookTheSpecificRoomOperation;

    public HotelController(BookTheSpecificRoomOperation bookTheSpecificRoomOperation) {
        this.bookTheSpecificRoomOperation = bookTheSpecificRoomOperation;
    }
}
