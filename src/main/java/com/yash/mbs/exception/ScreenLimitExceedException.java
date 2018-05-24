package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class ScreenLimitExceedException extends RuntimeException {
	public ScreenLimitExceedException(String errorMessage) {
		super(errorMessage);
	}
}
