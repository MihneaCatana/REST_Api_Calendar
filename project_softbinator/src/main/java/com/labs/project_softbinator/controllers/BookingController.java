package com.labs.project_softbinator.controllers;

import com.labs.project_softbinator.models.Booking;
import com.labs.project_softbinator.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/booking")
@RestController
public class BookingController {

    @Autowired
    private BookingService service;


    @PostMapping("/add")
    public Booking addBooking(@RequestBody Booking booking){
        return service.saveBooking(booking);
    }
}
