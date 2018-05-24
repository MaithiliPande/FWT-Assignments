package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class NullMovieObjectException extends RuntimeException{
	 
	public NullMovieObjectException(String errorMessage) {
		super(errorMessage);
	}
}
