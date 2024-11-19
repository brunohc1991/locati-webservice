package com.locati.webservice.domain;

import java.io.Serializable;
import java.util.Objects;

import com.locati.webservice.domain.enums.State;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CITY")
	private Long id;
	
	private String name;
	
	private Integer state;
	
	public City() {}
	
	public City(Long id) {
		this.id = id;
	}

	
	public City(Long id, String name, Integer state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}
	
	public City(Long id, String name, State state) {
		this(id, name, state.getCod());
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

	public State getState() {
		return State.fromCode(state);
	}

	public void setState(State state) {
		this.state = state.getCod();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(id, other.id);
	}
	
}
