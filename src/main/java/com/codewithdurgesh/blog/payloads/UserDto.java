package com.codewithdurgesh.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.codewithdurgesh.blog.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Username must be min of 4 char !!")
	private String name;
	
	@NotEmpty
	@Email(message = "Email address is not valid !!")
	private String email;
	
	@NotEmpty
	//@Size(min = 8, max = 10, message = "Password must be min of 8 char and max of 10 char !!")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
	message = "Password does not follow standard structure")
	//@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

}
