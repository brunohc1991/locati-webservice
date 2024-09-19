package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Address;
import com.locati.webservice.repositories.AddressRepository;
import com.locati.webservice.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository repository;
	
	public Address findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ". Tipo: " + Address.class.getName()));
	}
	
	public List<Address> findAll() {
		return repository.findAll();
	}

}
