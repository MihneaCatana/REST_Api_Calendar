package com.labs.project_softbinator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_booking;

    private String description;

    private LocalDateTime booking_date;

    @ManyToOne
    @JoinColumn(name = "user_id_booking")
    private User user;

    @OneToMany(mappedBy = "booking")
    Set<Junc_Booking_Calendar> bookings;


}
