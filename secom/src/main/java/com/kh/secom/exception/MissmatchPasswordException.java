package com.kh.secom.exception;

public class MissmatchPasswordException extends RuntimeException{

	public MissmatchPasswordException(String message) {
		super(message);
	}
}
