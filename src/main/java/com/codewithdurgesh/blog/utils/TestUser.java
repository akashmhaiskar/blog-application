package com.codewithdurgesh.blog.utils;

public class TestUser {

	
	public static void main(String[] args) {
		User user = new User("John", "9874563210", "John", "john9#");
		try {
			UserBO.validate(user);
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		}
	}
}
