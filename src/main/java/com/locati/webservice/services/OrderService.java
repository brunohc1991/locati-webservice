package com.locati.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locati.webservice.domain.Order;
import com.locati.webservice.repositories.OrderRepository;
import com.locati.webservice.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	public Order findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ". Tipo: " + Order.class.getName()));
	}
	
	public List<Order> findAll() {
		return repository.findAll();
	}

}
