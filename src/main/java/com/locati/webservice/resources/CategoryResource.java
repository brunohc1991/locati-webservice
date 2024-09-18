package com.locati.webservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locati.webservice.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@GetMapping()
	public ResponseEntity<List<Category>> listAll() {
		Category cat1 = new Category();
		cat1.setId(1L);
		cat1.setName("Informática");
		Category cat2 = new Category();
		cat2.setId(2L);
		cat2.setName("Escritório");
		
		List<Category> list = new ArrayList<>();
		list.add(cat1);
		list.add(cat2);
		
		return 	ResponseEntity.ok(list);
	}

}
