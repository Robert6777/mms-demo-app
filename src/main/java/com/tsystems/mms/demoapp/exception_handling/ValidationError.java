package com.tsystems.mms.demoapp.exception_handling;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
	
	private List<CustomFieldError> fieldErrors = new ArrayList<>();

    public List<CustomFieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<CustomFieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    void addFieldError(String field, String message) {
        CustomFieldError error = new CustomFieldError(field, message);
        fieldErrors.add(error);
    }

    private static class CustomFieldError {

        private String field;
        private String message;

        public CustomFieldError() {
        }

        public CustomFieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

}
