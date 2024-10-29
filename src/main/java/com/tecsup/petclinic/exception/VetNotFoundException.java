package com.tecsup.petclinic.exception;

/**
 * Exception thrown when a Vet is not found in the database.
 */
public class VetNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public VetNotFoundException(String message) {
        super(message);
    }
}