package com.codeid.microservices.exceptions;

@SuppressWarnings("serial")
public class EntityNotFoundException extends AppException {

    public EntityNotFoundException() {
        super(ErrorCodes.ENTITY_NOT_FOUND, "exception.entity.not.found");
    }
    
}