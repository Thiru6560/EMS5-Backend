package com.ems.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((org.springframework.validation.FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Map<String, Object>> handleBadRequestException(BadRequestException e) {

		Map<String, Object> errorDetails = new HashMap<>();

		errorDetails.put("message", e.getMessage());
		errorDetails.put("status", HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<Map<String, Object>> handleEmptyFieldException(EmptyFieldException e) {

		Map<String, Object> errorDetails = new HashMap<>();

		errorDetails.put("message", e.getMessage());
		errorDetails.put("status", HttpStatus.NO_CONTENT.value());

		return new ResponseEntity<>(errorDetails, HttpStatus.OK);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<Map<String, Object>> handleUnauthorizedException(UnauthorizedException e) {

		Map<String, Object> errorDetails = new HashMap<>();

		errorDetails.put("message", e.getMessage());
		errorDetails.put("status", HttpStatus.UNAUTHORIZED.value());

		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(DuplicateDataException.class)
	public ResponseEntity<Map<String, Object>> handleDuplicateDataException(DuplicateDataException e) {

		Map<String, Object> errorDetails = new HashMap<>();

		errorDetails.put("message", e.getMessage());
		errorDetails.put("status", HttpStatus.ALREADY_REPORTED.value());

		return new ResponseEntity<>(errorDetails, HttpStatus.ALREADY_REPORTED);
	}

	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<Map<String, Object>> handleNoSuchUserException(NoSuchUserException e) {

		Map<String, Object> errorDetails = new HashMap<>();

		errorDetails.put("message", e.getMessage());
		errorDetails.put("status", HttpStatus.NOT_FOUND.value());
		System.out.println(e.getMessage() + "------");

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoLocationFoundException.class)
	public ResponseEntity<Map<String, Object>> handleNoLocationFoundException(NoLocationFoundException e) {

		Map<String, Object> errorDetails = new HashMap<>();

		errorDetails.put("message", e.getMessage());
		errorDetails.put("status", HttpStatus.NOT_FOUND.value());
		System.out.println(e.getMessage() + "------");

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
