package com.codewithdurgesh.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.UserDto;
import com.codewithdurgesh.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//post - create user
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		
		UserDto createUserDto = userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);		
		
	}
	
	
	// Put - update user
	@RequestMapping(value = "/{userId}" , method = RequestMethod.PUT)
public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, 
		@PathVariable("userId") Integer userId){
		
		
		UserDto updatedUser = userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);	
		
	}
	
	
	//Delete - delete user
	//Admin
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/{userId}" , method = RequestMethod.DELETE)
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
			
			
			userService.deleteUser(userId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);	
			
		}
	
	
	//get - user get
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getAllUsers(){
			
			
			List<UserDto> allUsers = userService.getAllUsers();
			return ResponseEntity.ok(allUsers);	
			
		}
//	
	@RequestMapping(value = "/{userId}" , method = RequestMethod.GET)
	public ResponseEntity<UserDto> getSingleUserById(@PathVariable("userId") Integer userId){
			
			return ResponseEntity.ok(userService.getUserById(userId));	
			
		}
	
}
