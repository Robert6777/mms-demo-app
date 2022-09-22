package com.tsystems.mms.demoapp.exception_handling;

public class ApiError {

	private String message;
    private ErrorSeverity severity;

    public ApiError(String exceptionMessage, ErrorSeverity severity) {
        this.message = exceptionMessage;
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ErrorSeverity severity) {
        this.severity = severity;
    }

}
