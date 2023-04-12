package com.labs.project_softbinator.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookingDto {

    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date booking_date;

    private int user_id;
}
