package com.locati.webservice.domain.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.locati.webservice.domain.Client;
import com.locati.webservice.services.validations.EmailUnique;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ClientDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty
	@Length(min = 5, max = 120)
	private String name;
	
	@Email
	@NotEmpty
	@EmailUnique
	private String email;
	
	
	public ClientDTO() {}
	
	public ClientDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.email = client.getEmail();
	}
	
	public ClientDTO(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
