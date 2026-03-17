package com.seuprojeto.contacts_api.services.exeptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
}
