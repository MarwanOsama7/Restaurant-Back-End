package com.global.RestaurantManage.error;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.global.RestaurantManage.error.entity.ErrorResponse;

@ControllerAdvice
public class GlobalExectionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> handleNotfound(RecordNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage(),Arrays.asList(ex.getMessage()));
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(errorResponse);
	}
}
