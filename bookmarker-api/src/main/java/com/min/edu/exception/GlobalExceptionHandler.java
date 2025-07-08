package com.min.edu.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.domain.CreateBookmarkRequest;

import jakarta.validation.Valid;

// @ControllerAdvice 를 사용하여 전역 예외를 처리
// @RequestBody @Valid CreateBookmarkRequest request 의 오류 결과를 반환처리 하기 위해

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, Object> errorResponse = new HashMap<String, Object>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			
			errorResponse.put("field", fieldName);
			errorResponse.put("message", errorMessage);
			
		});
		
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		
	}
}










