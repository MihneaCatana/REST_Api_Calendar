package com.labs.project_softbinator.controllers;

import com.labs.project_softbinator.models.Junc_Booking_Calendar;
import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.services.JuncService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/junc")
@RestController
public class JuncController {

    private JuncService service;

    @GetMapping("/get")
    public List<Junc_Booking_Calendar> findAllJuncs()
    {
        return service.getJuncs();
    }

    @PostMapping("/add")
    public Junc_Booking_Calendar addJunc(@RequestBody Junc_Booking_Calendar juncBookingCalendar){
        return service.saveJunc(juncBookingCalendar);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteJunc(@PathVariable int id){
        service.deleteJunc(id);
        return "Junc deleted with ID: "+id;
    }
}
