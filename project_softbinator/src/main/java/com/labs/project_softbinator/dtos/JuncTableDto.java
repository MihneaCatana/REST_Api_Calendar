package com.labs.project_softbinator.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JuncTableDto {

    private int calendar_id;

    private int booking_id;
}
