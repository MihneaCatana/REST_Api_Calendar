package com.labs.project_softbinator.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CalendarDto {

    private int id;

    private Date startDate;

    private Date endDate;

    private int id_user;
}
