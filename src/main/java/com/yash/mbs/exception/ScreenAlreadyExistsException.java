package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class ScreenAlreadyExistsException extends RuntimeException{
	
	public ScreenAlreadyExistsException(String errMessage) {
		super(errMessage);
	}
}
