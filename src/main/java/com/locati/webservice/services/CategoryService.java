package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Category;
import com.locati.webservice.dto.CategoryDTO;
import com.locati.webservice.repositories.CategoryRepository;
import com.locati.webservice.services.exceptions.DataIntegrityException;
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

	public Category insert(CategoryDTO objDto) {
		objDto.setId(null);
		Category obj = new Category(objDto);
		return repository.save(obj);
	}
	
	public Category update(CategoryDTO objDto) {
		Category obj = new Category(objDto);
		findById(obj.getId());
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {			
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(Category.class);
		}
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction.toUpperCase()), orderBy);
		return repository.findAll(pageRequest);
	}

}
