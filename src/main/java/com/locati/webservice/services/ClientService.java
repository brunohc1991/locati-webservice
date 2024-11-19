package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Client;
import com.locati.webservice.domain.dto.ClientDTO;
import com.locati.webservice.domain.dto.NewClientDTO;
import com.locati.webservice.repositories.AddressRepository;
import com.locati.webservice.repositories.ClientRepository;
import com.locati.webservice.services.exceptions.DataIntegrityException;
import com.locati.webservice.services.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public Client findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ". Tipo: " + Client.class.getName()));
	}
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client update(ClientDTO objDto) {
		Client obj = findById(objDto.getId());
		obj.setName(objDto.getName());
		obj.setEmail(objDto.getEmail());
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {			
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(Client.class);
		}
	}
	
	@Transactional
	public Client insert(NewClientDTO objDto) {
		Client obj = new Client(objDto);
		obj = repository.save(obj);
		addressRepository.saveAll(obj.getAddress());
		return obj;
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction.toUpperCase()), orderBy);
		return repository.findAll(pageRequest);
	}

}
