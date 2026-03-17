package com.seuprojeto.contacts_api.resource.exeptions;





import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class ValidationErrorHandler extends StandardError {
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationErrorHandler() {
    }

    public ValidationErrorHandler(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addError(String field, String message) {
        errors.add(new FieldMessage(field, message));
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }
}

