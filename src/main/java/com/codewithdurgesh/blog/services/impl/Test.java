package com.codewithdurgesh.blog.services.impl;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(Integer.valueOf(1).hashCode());
		System.out.println(Long.valueOf(1).hashCode());
		
		Integer valueOf = Integer.valueOf(1);
		Long valueOf2 = Long.valueOf(1);
		
		System.out.println(valueOf.equals(valueOf2));
		
		
		
	}
}
