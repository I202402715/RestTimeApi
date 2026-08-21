package com.resttime.exception.cases;

public class NoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NoEncontradoException (String message){
		super(message);
	}
}
