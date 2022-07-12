package com.codewithdurgesh.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	
	private Integer categoryId;
	
	@NotEmpty
	@Size(min = 4, message = "Category Title must be min of 4 char !!")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 10, message = "Category Description must be min of 10 char !!")
	private String categoryDescription;
}
