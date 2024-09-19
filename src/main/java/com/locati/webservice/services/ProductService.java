package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Product;
import com.locati.webservice.repositories.ProductRepository;
import com.locati.webservice.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public Product findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ". Tipo: " + Product.class.getName()));
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}

}
