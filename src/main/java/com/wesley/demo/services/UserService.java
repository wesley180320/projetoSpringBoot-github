package com.wesley.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wesley.demo.entities.User;
import com.wesley.demo.repositories.UserReposositoy;
import com.wesley.demo.services.exceptions.DataBaseException;
import com.wesley.demo.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {

	@Autowired
	private UserReposositoy repository;

	public List<User> findAll() {

		return repository.findAll();

	}

	public User findById(Long id) {

		Optional<User> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	
	public User insert(User obj) {
		
		return repository.save(obj);
	}

	public void delete(long id) {

		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {

			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataBaseException(e.getMessage());
		}

	}

	public User update(Long id, User obj) {

	
		try {
		User entity = repository.getOne(id);

		update(entity, obj);
		return repository.save(entity);
		}catch( EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}

	private void update(User entity, User obj) {

		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPhone(obj.getPhone());
	}
}
