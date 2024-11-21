package com.locati.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.locati.webservice.domain.Product;
import com.locati.webservice.domain.dto.ProductDTO;
import com.locati.webservice.resources.utils.URL;
import com.locati.webservice.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return 	ResponseEntity.ok(service.findById(id));
	}

	@GetMapping(value = "/search")
	public ResponseEntity<Page<ProductDTO>> search(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categories", defaultValue = "") String categories,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		List<Long> categoryIds = URL.decodeLongList(categories);
		String nameDecoded = URL.decodeParam(name);
		
		Page<Product> product = service.search(nameDecoded, categoryIds, page, linesPerPage, orderBy, direction);
		
		Page<ProductDTO> productDTO = product.map(item -> new ProductDTO(item));
		return ResponseEntity.ok(productDTO);
	}
}
