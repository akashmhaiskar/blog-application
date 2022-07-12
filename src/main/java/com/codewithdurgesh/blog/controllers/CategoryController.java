package com.codewithdurgesh.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.services.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;

	//create
	
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		
		CategoryDto createCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategory, HttpStatus.CREATED);		
		
	}
	
	
	
	//update
	
	@RequestMapping(value = "/{categoryId}" , method = RequestMethod.PUT)
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, 
			@PathVariable("categoryId") Integer categoryId){
			
		    CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, categoryId);
			return ResponseEntity.ok(updatedCategory);	
			
		}
	
	//delete
	
	@RequestMapping(value = "/{categoryId}" , method = RequestMethod.DELETE)
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId){
			
		    categoryService.deleteCategory(categoryId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully", true), HttpStatus.OK);	
			
		}
	
	//getAll
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
			
		List<CategoryDto> allCategory = categoryService.getAllCategory();
			return ResponseEntity.ok(allCategory);	
			
		}
	
	//get
	
	@RequestMapping(value = "/{categoryId}" , method = RequestMethod.GET)
	public ResponseEntity<CategoryDto> getSingleCategoryById(@PathVariable("categoryId") Integer categoryId){
			
		CategoryDto categoryDto = categoryService.getCategory(categoryId);
		
			return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);	
			
		}
	
	
	
	
	
	
}
