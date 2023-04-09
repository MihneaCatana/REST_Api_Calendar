package com.labs.project_softbinator.services;

import com.labs.project_softbinator.models.Booking;
import com.labs.project_softbinator.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public Booking saveBooking(Booking booking) {return repository.save(booking);}
    public List<Booking> saveBookings(List<Booking> bookings){
       return repository.saveAll(bookings);
    }

    public List<Booking> getBookings(){
        return repository.findAll();
    }

    public Booking getBookingById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteBooking(int id){
        repository.deleteById(id);
        return "Booking deleted ! id: "+id;
    }

    public Booking updateBooking(Booking booking){
        Booking existingBooking = repository.findById(booking.getId_booking()).orElse(null);
        existingBooking.setUser(booking.getUser());
        existingBooking.setBooking_date(booking.getBooking_date());
//        existingBooking.setDescription();
        return repository.save(existingBooking);
    }

}
