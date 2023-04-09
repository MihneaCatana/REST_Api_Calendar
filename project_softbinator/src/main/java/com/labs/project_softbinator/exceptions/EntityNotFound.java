package com.labs.project_softbinator.exceptions;

import java.lang.reflect.Type;

public class EntityNotFound extends BadRequestException {

    private static final String EXCEPTION_MESSAGE = "Entity could not be found for id: ";

    public EntityNotFound(int id, Type issuedInClass) {
        super(EXCEPTION_MESSAGE + id, issuedInClass);
    }
}
