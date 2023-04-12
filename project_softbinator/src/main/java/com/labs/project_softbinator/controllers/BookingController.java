package com.labs.project_softbinator.controllers;

import com.labs.project_softbinator.dtos.BookingDto;
import com.labs.project_softbinator.exceptions.EntityNotFound;
import com.labs.project_softbinator.models.Booking;
import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.services.BookingService;
import com.labs.project_softbinator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/booking")
@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<Booking> findAllBookings() {
        return bookingService.getBookings();
    }

    @PostMapping("/add")
    public String addBooking(@RequestBody BookingDto booking) {

        bookingService.saveBooking(booking);

        return "Booking was added with success!";
    }

    @PutMapping("/update/{id}")
    public String updateBooking(@PathVariable int id, @RequestBody BookingDto bookingDto) {

        Booking booking = bookingService.getBookingById(id);
        if (booking == null)
            throw new EntityNotFound(id, BookingController.class);

        /**
         *  Update in Users list for syncronization
         * */
        User oldUser = booking.getUser();
        oldUser.getBookings().remove(booking);
        User user = userService.getUserById(bookingDto.getUser_id());
        booking.setUser(user);
        user.getBookings().add(booking);

        bookingService.updateBooking(id, bookingDto);

        return "Booking with id: " + id + " was successfully updated!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCalendar(@PathVariable int id) {
        bookingService.deleteBooking(id);
        return "Booking deleted with ID: " + id;
    }
}
