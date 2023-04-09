package com.labs.project_softbinator.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Junc_Table implements Serializable {

    @Column(name="calendar_id")
    int calendarId;

    @Column(name = "booking_id")
    int bookingId;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(this.calendarId > ((Junc_Table)obj).calendarId)
            return true;
        else
            if(this.calendarId < ((Junc_Table)obj).calendarId)
                return false;
            else
                return  compareBookings(obj);
    }

    private boolean compareBookings(Object obj)
    {
        if(this.bookingId > ((Junc_Table)obj).bookingId)
            return true;
        else
        if(this.calendarId < ((Junc_Table)obj).bookingId)
            return false;

        return false;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }


}
