package com.codeid.microservices.exceptions;

@SuppressWarnings("serial")
public class PathNotFoundException extends AppException {

    public PathNotFoundException() {
        super(ErrorCodes.PATH_NOT_FOUND, "exception.path.not.found");
    }
}