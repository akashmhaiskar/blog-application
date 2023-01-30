package com.codewithdurgesh.blog.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdurgesh.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
