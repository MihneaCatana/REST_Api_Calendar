package com.labs.project_softbinator.controllers;

import com.labs.project_softbinator.dtos.JuncTableDto;
import com.labs.project_softbinator.models.Junc_Booking_Calendar;
import com.labs.project_softbinator.services.JuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/junc")
@RestController
public class JuncController {

    @Autowired
    private JuncService service;

    @GetMapping("/get")
    public List<Junc_Booking_Calendar> findAllJuncs() {
        return service.getJuncs();
    }

    @PostMapping("/add")
    public String addJunc(@RequestBody JuncTableDto juncBookingCalendar) {

        service.saveJunc(juncBookingCalendar.getCalendar_id(), juncBookingCalendar.getBooking_id());
        return "Junc Table was made succesfully! ";
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteJunc(@PathVariable int id){
//        service.deleteJunc(id);
//        return "Junc deleted with ID: "+id;
//    }
}
