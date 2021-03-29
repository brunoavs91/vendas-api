package com.bruno.vendasapi.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> exception(Exception ex, HttpServletRequest request) {
		StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.EXPECTATION_FAILED.value(), "Ocorreu um erro", ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(erro);
	}
	
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<StandardError> businessException(BusinessException ex, HttpServletRequest request) {

		StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.EXPECTATION_FAILED.value(), "Ocorreu um erro", ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(erro);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

		StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Objeto nao encontrado", ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
