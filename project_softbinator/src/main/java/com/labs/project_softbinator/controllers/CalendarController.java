package com.labs.project_softbinator.controllers;

import com.labs.project_softbinator.dtos.CalendarDto;
import com.labs.project_softbinator.exceptions.EntityNotFound;
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
    private CalendarService calendarService;

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<Calendar> findAllUsers()
    {
        return calendarService.getCalendars();
    }

    @PostMapping("/add")
    public String addCalendar(@RequestBody CalendarDto calendar){

       calendarService.saveCalendar(calendar);

       return "Calendar was added with success!";
    }

    @PutMapping("/update/{id}")
    public String updateCalendar(@PathVariable int id,@RequestBody CalendarDto calendarDto){

        Calendar calendar = calendarService.getCalendarById(id);

        if(calendar == null)
            throw new EntityNotFound(id,CalendarController.class);

        User oldUser = calendar.getUser();
        oldUser.setCalendar(null);

        User user = userService.getUserById(calendarDto.getUser_id());
        user.setCalendar(calendar);

        calendarService.updateCalendar(id,calendarDto);

        return "Calendar with id: "+id+" was successfully updated!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCalendar(@PathVariable int id){
        calendarService.deleteCalendar(id);
        return "Calendar deleted with ID: "+id;
    }
}
