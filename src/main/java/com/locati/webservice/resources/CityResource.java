package com.locati.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locati.webservice.domain.City;
import com.locati.webservice.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {
	
	@Autowired
	private CityService service;
	
	@GetMapping
	public ResponseEntity<List<City>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<City> findById(@PathVariable Long id) {
		return 	ResponseEntity.ok(service.findById(id));
	}

}
