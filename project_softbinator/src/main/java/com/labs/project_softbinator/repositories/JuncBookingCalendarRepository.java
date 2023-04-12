package com.labs.project_softbinator.repositories;

import com.labs.project_softbinator.models.Junc_Booking_Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuncBookingCalendarRepository extends JpaRepository<Junc_Booking_Calendar, Integer> {

}
