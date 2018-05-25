package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class NullObjectException extends RuntimeException {
	
	public NullObjectException(String error) {
		super(error);
	}
}
