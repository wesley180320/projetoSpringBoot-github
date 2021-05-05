package com.wesley.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.demo.entities.User;

public interface UserReposositoy extends JpaRepository<User, Long>{

	
}
