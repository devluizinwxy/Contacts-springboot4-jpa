package com.seuprojeto.contacts_api.services.exeptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found. ID "+ id);
    }
}
