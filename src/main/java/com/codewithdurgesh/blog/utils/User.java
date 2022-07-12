package com.codewithdurgesh.blog.utils;

public class User {

	private String name;
	private String mobile;
	private String userName;
	private String password;
	
	public User(String name, String mobile, String userName, String password) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.userName = userName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
