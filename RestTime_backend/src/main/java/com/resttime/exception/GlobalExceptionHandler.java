package com.resttime.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.resttime.usuario.dto.ErrorResponse;
import com.resttime.exception.cases.CredencialesException;
import com.resttime.exception.cases.FallidoException;
import com.resttime.exception.cases.NoEncontradoException;
import com.resttime.exception.cases.UsuarioExistenteException;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CredencialesException.class)
	public ResponseEntity<ErrorResponse> manejarCredenciales(
			CredencialesException ex,
			HttpServletRequest request){
		
		ErrorResponse error = new ErrorResponse(
				HttpStatus.UNAUTHORIZED.value(),
				"Unauthorized",
				ex.getMessage(),
				request.getRequestURI()
				);
		
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
	}
	
	@ExceptionHandler(UsuarioExistenteException.class)
	public ResponseEntity<ErrorResponse> manejarExistente(
			UsuarioExistenteException ex,
			HttpServletRequest request){
		
		ErrorResponse error = new ErrorResponse(
				HttpStatus.CONFLICT.value(),
				"Conflict",
				ex.getMessage(),
				request.getRequestURI()
				);
		
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(NoEncontradoException.class)
	public ResponseEntity<ErrorResponse> manejarNoEncotntrado(
			NoEncontradoException ex,
			HttpServletRequest request){
		
		ErrorResponse error = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				"Conflict",
				ex.getMessage(),
				request.getRequestURI()
				);
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(FallidoException.class)
	public ResponseEntity<ErrorResponse> manejarFallido(
			FallidoException ex,
			HttpServletRequest request){
		
		ErrorResponse error = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"ERROR",
				ex.getMessage(),
				request.getRequestURI()
				);
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
}
