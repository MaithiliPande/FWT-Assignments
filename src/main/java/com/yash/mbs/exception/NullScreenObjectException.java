package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class NullScreenObjectException extends RuntimeException {
	
	public NullScreenObjectException(String error) {
		super(error);
	}
}
