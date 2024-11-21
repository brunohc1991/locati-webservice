package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Category;
import com.locati.webservice.domain.Product;
import com.locati.webservice.repositories.CategoryRepository;
import com.locati.webservice.repositories.ProductRepository;
import com.locati.webservice.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	public Product findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ". Tipo: " + Product.class.getName()));
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Page<Product> search(String name, List<Long> categoryIds, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction.toUpperCase()), orderBy);
		List<Category> categories = (categoryIds == null || categoryIds.isEmpty()) ? catRepository.findAll() : catRepository.findAllById(categoryIds);
		return repository.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
	}

}
