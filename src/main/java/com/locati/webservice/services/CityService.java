package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.City;
import com.locati.webservice.repositories.CityRepository;
import com.locati.webservice.services.exceptions.ObjectNotFoundException;

@Service
public class CityService {
	
	@Autowired
	CityRepository repository;
	
	public City findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ". Tipo: " + City.class.getName()));
	}
	
	public List<City> findAll() {
		return repository.findAll();
	}

}
