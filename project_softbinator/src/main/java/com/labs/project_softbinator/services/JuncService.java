package com.labs.project_softbinator.services;

import com.labs.project_softbinator.dtos.JuncTableDto;
import com.labs.project_softbinator.models.Booking;
import com.labs.project_softbinator.models.Calendar;
import com.labs.project_softbinator.models.Junc_Booking_Calendar;
import com.labs.project_softbinator.models.Junc_Table;
import com.labs.project_softbinator.repositories.BookingRepository;
import com.labs.project_softbinator.repositories.CalendarRepository;
import com.labs.project_softbinator.repositories.JuncBookingCalendarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuncService {

    @Autowired
    private JuncBookingCalendarRepository juncBookingCalendarRepository;

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public void saveJunc(int calendar_id, int booking_id) {

        Junc_Table tabel= new Junc_Table(calendar_id,booking_id);
        Calendar calendar = calendarRepository.findById(calendar_id).orElse(null);
        Booking booking = bookingRepository.findById(booking_id).orElse(null);
        juncBookingCalendarRepository.save(new Junc_Booking_Calendar(tabel,calendar,booking));
    }

    public List<Junc_Booking_Calendar> saveJuncs(List<Junc_Booking_Calendar> juncBookingCalendarList){
        return juncBookingCalendarRepository.saveAll(juncBookingCalendarList);
    }

    public List<Junc_Booking_Calendar> getJuncs(){
        return juncBookingCalendarRepository.findAll();
    }

    public Junc_Booking_Calendar getJuncById(int id){
        return juncBookingCalendarRepository.findById(id).orElse(null);
    }

    public String deleteJunc(int idBooking){
        juncBookingCalendarRepository.deleteById(idBooking);
        return "User deleted ! id: "+idBooking;
    }
}
