package com.tsystems.mms.demoapp.exception_handling;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ApiError> handleException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError(ex.getMessage(), ErrorSeverity.ERROR), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handleValidationError(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        return new ResponseEntity<>(processFieldErrors(fieldErrors), HttpStatus.BAD_REQUEST);
    }

    private ValidationError processFieldErrors(List<FieldError> fieldErrors) {
        ValidationError validationError = new ValidationError();
        for (FieldError fieldError : fieldErrors) {
            validationError.addFieldError(fieldError.getField(), fieldError.getCode());
    
        }
        return validationError;
    }


    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<ApiError> accessDenied(AccessDeniedException ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ApiError("Access denied!", ErrorSeverity.ERROR), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Throwable.class)
    public final ResponseEntity<ApiError> handleException(Throwable ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ApiError("Unexpected error", ErrorSeverity.ERROR), HttpStatus.BAD_REQUEST);
    }

    private static enum ErrorSeverity {
        WARN,
        ERROR,
        FATAL
    }

    private static class ApiError {

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

	
	
	
	
	

}
