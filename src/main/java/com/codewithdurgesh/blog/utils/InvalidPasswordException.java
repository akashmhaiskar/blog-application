package com.codewithdurgesh.blog.utils;

public class InvalidPasswordException extends Exception{
	
	private String message;
	
	public InvalidPasswordException(String message) {
		super(message);
	}

}
