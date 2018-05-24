package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class IncorrectInputException extends RuntimeException {
	public IncorrectInputException(String error) {
		super(error);
	}
}
