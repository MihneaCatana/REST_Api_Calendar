package com.labs.project_softbinator.controllers;

import com.labs.project_softbinator.dtos.BookingDto;
import com.labs.project_softbinator.models.Booking;
import com.labs.project_softbinator.models.Calendar;
import com.labs.project_softbinator.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/booking")
@RestController
public class BookingController {

    @Autowired
    private BookingService service;

    @GetMapping("/get")
    public List<Booking> findAllBookings()
    {
        return service.getBookings();
    }

    @PostMapping("/add")
    public void addBooking(@RequestBody BookingDto booking){

        service.saveBooking(booking);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCalendar(@PathVariable int id){
        service.deleteBooking(id);
        return "Booking deleted with ID: "+id;
    }
}
