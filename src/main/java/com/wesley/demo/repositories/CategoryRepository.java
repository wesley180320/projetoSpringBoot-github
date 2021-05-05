package com.wesley.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesley.demo.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long>{

	
}
