package com.wesley.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesley.demo.entities.Category;
import com.wesley.demo.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findall() {

		return repository.findAll();

	}

	public Category fidById(Long id) {

		Optional<Category> obj = repository.findById(id);

		return obj.get();
	}

}
