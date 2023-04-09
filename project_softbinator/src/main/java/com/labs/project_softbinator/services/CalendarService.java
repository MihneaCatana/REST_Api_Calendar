package com.labs.project_softbinator.services;


import com.labs.project_softbinator.dtos.CalendarDto;
import com.labs.project_softbinator.models.Calendar;
import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.repositories.CalendarRepository;
import com.labs.project_softbinator.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public Calendar saveCalendar(CalendarDto calendarDto) {

        User user = userRepository.getById(calendarDto.getId());

        Calendar calendar = Calendar.builder().start_date(calendarDto.getStartDate())
                    .end_date(calendarDto.getEndDate())
                .user(user).build();

        return  calendarRepository.save(calendar);
    }

    public List<Calendar> saveCalendars(List<Calendar> Calendars){
        return calendarRepository.saveAll(Calendars);
    }

    public List<Calendar> getCalendars(){
        return calendarRepository.findAll();
    }

    public Calendar getCalendarById(int id){
        return calendarRepository.findById(id).orElse(null);
    }

    public String deleteCalendar(int id){
        calendarRepository.deleteById(id);
        return "Calendar deleted ! id: "+id;
    }
}
