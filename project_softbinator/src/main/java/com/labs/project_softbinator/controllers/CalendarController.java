package com.labs.project_softbinator.controllers;

import com.labs.project_softbinator.dtos.CalendarDto;
import com.labs.project_softbinator.models.Calendar;
import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.services.CalendarService;
import com.labs.project_softbinator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/calendar")
@RestController
public class CalendarController {

    @Autowired
    private CalendarService service;

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public List<Calendar> findAllUsers()
    {
        return service.getCalendars();
    }

    @PostMapping("/add")
    public void addCalendar(@RequestBody CalendarDto calendar){

       service.saveCalendar(calendar);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCalendar(@PathVariable int id){
        service.deleteCalendar(id);
        return "Calendar deleted with ID: "+id;
    }
}
