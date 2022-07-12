package com.codewithdurgesh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithdurgesh.blog.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>{

}
