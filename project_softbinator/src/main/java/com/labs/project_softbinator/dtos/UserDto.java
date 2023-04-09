package com.labs.project_softbinator.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private int id;

    private String name;

    private String email;

    private String password;

    private String role;

}
