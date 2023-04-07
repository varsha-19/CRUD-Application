package com.example.springboot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling global exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorDetails errorDetails =
				new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> globalExceptionHandling(MethodArgumentTypeMismatchException exception, WebRequest request){
		ErrorDetails errorDetails =
				new ErrorDetails(new Date(), "Method Type Mismatch", request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorDetails> handleException(APIException exception, WebRequest request)
	{
		ErrorDetails errorDetails =
				new ErrorDetails(new Date(), exception.getErrorCode(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, exception.getHttpStatusCode());
	}
}