package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class ScreenDoesNotExistException extends RuntimeException{
	public ScreenDoesNotExistException(String errorMessage) {
		super(errorMessage);
	}

}
