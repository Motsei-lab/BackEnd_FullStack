package com.mecerintered.backend_fullstack.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException (Long id){
        super("Person with id: " + id + " has not been found");
    }
}
