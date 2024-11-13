package com.locati.webservice.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.locati.webservice.domain.Category;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min = 5, max = 80)
	private String name; 
	
	public CategoryDTO() {}
	
	public CategoryDTO(Category obj) {
		this.id = obj.getId();
		this.name = obj.getName();
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

}
