package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Category;
import com.locati.webservice.repositories.CategoryRepository;
import com.locati.webservice.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	public Category findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ". Tipo: " + Category.class.getName()));
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}

}
