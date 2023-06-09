package com.labs.project_softbinator.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_calendar;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start_date;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end_date;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    Set<Junc_Booking_Calendar> calendars;

    @Override
    public String toString() {
        return "CalendarUser{" +
                "start_date=" + start_date +
                ", end_date=" + end_date +
                ", user=" + user.toString() +
                '}';
    }
}
