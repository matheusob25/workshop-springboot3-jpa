package com.matheusob25.projetoweb.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
       super("Resource not found with id " + id);
    }
}
