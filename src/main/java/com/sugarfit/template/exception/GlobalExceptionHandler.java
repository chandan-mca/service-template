package com.sugarfit.template.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sugarfit.template.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

		log.warn("Validation failed: {} errors", ex.getBindingResult().getErrorCount());
		
		String requestId = MDC.get("requestId");
		
		// Fallback in case requestId is missing (edge case)
		if (requestId == null) {
		    requestId = "N/A";
		}

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors()
	            .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	            .body(new ErrorResponse("ERROR", requestId, errors));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {

	    log.error("Unexpected error occurred", ex);

	    String requestId = MDC.get("requestId");
	    
	    // Fallback in case requestId is missing (edge case)
	    if (requestId == null) {
	        requestId = "N/A";
	    }

	    Map<String, String> error;

	    // Handle JSON parse error here
	    if (ex instanceof org.springframework.http.converter.HttpMessageNotReadableException) {
	        error = Map.of("message", "Invalid request body");

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(new ErrorResponse("ERROR", requestId, error));
	    }

	    // default case
	    error = Map.of(
	        "message", (ex.getMessage() != null) ? ex.getMessage() : "Unexpected error"
	    );

	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body(new ErrorResponse("ERROR", requestId, error));
	}
}