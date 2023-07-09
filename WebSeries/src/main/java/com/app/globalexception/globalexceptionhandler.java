package com.app.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.excpetion.CustomException;

@RestControllerAdvice
public class globalexceptionhandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> customexception(CustomException c) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException(c.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException c) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new CustomException(c.getFieldError().getDefaultMessage()));
	}
}
