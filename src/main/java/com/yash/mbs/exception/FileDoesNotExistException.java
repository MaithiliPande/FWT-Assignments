package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class FileDoesNotExistException extends RuntimeException{
	public FileDoesNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
