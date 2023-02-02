package com.codewithdurgesh.blog;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codewithdurgesh.blog.config.AppConstants;
import com.codewithdurgesh.blog.entities.Role;
import com.codewithdurgesh.blog.services.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {		
		try {
			Role adminRole = new Role();
			adminRole.setId(AppConstants.ADMIN_USER);
			adminRole.setName("ROLE_ADMIN");
			
			Role normalRole = new Role();
			normalRole.setId(AppConstants.NORMAL_USER);
			normalRole.setName("ROLE_NORMAL");
			
			List<Role> roles = new ArrayList<>();
			roles.add(normalRole);
			roles.add(adminRole);			
			List<Role> result = roleRepo.saveAll(roles);
			
			result.forEach(r -> System.out.println(r.getName()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
