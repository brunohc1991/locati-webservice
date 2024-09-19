package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Client;
import com.locati.webservice.repositories.ClientRepository;
import com.locati.webservice.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	public Client findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ". Tipo: " + Client.class.getName()));
	}
	
	public List<Client> findAll() {
		return repository.findAll();
	}

}
