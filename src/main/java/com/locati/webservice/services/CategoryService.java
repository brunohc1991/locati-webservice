package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Category;
import com.locati.webservice.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	public Category findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}

}
