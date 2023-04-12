package com.labs.project_softbinator.services;

import com.labs.project_softbinator.dtos.BookingDto;
import com.labs.project_softbinator.models.Booking;
import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.repositories.BookingRepository;
import com.labs.project_softbinator.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveBooking(BookingDto bookingDto) {

        User user = userRepository.getById(bookingDto.getUser_id());

        Booking booking = Booking.builder().booking_date(bookingDto.getBooking_date()).user(user).description(bookingDto.getDescription()).build();

        user.getBookings().add(booking);
        bookingRepository.save(booking);

    }

    public List<Booking> saveBookings(List<Booking> bookings) {
        return bookingRepository.saveAll(bookings);
    }

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }


    public String deleteBooking(int id) {
        bookingRepository.deleteById(id);
        return "Booking deleted ! id: " + id;
    }

    public Booking updateBooking(int id, BookingDto booking) {
        Booking existingBooking = bookingRepository.findById(id).orElse(null);
        existingBooking.setBooking_date(booking.getBooking_date());
        existingBooking.setDescription(booking.getDescription());
        return bookingRepository.save(existingBooking);
    }

}
