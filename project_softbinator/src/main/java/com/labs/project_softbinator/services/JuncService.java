package com.labs.project_softbinator.services;

import com.labs.project_softbinator.models.Junc_Booking_Calendar;
import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.repositories.JuncBookingCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuncService {

    @Autowired
    private JuncBookingCalendarRepository repository;

    public Junc_Booking_Calendar saveJunc(Junc_Booking_Calendar juncBookingCalendar) {
        return repository.save(juncBookingCalendar);
    }

    public List<Junc_Booking_Calendar> saveJuncs(List<Junc_Booking_Calendar> juncBookingCalendarList){
        return repository.saveAll(juncBookingCalendarList);
    }

    public List<Junc_Booking_Calendar> getJuncs(){
        return repository.findAll();
    }

    public Junc_Booking_Calendar getJuncById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteJunc(int id){
        repository.deleteById(id);
        return "User deleted ! id: "+id;
    }
}
