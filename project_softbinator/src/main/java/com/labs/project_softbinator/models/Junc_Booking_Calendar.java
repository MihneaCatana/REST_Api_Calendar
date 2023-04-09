package com.labs.project_softbinator.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Junc_Booking_Calendar {

    @EmbeddedId
    Junc_Table id;

    @ManyToOne
    @MapsId("calendarId")
    @JoinColumn(name = "calendar_id")
    Calendar calendar;

    @ManyToOne
    @MapsId("bookingId")
    @JoinColumn(name = "booking_id")
    Booking booking;

    @Override
    public String toString() {
        return "Junc_Booking_Calendar{" +
                "id=" + id +
                ", calendar=" + calendar +
                ", booking=" + booking +
                '}';
    }
}
