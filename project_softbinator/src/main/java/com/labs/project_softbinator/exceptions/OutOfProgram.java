package com.labs.project_softbinator.exceptions;

import java.lang.reflect.Type;

public class OutOfProgram extends BadRequestException {

    private static final String EXCEPTION_MESSAGE = "The booking is out of the employee's calendar ! ";

    public OutOfProgram(Type issuedInClass) {
        super(EXCEPTION_MESSAGE, issuedInClass);
    }
}
