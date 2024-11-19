package com.locati.webservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locati.webservice.domain.dto.ClientDTO;
import com.locati.webservice.domain.dto.NewClientDTO;
import com.locati.webservice.domain.enums.ClientType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENT")
	private Long id;
	private String name;
	private String email;
	private String cpfOrCnpj;
	private Integer type;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
	
	@OneToMany(mappedBy = "client")
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "PHONE")
	private Set<String> phones = new HashSet<>();
	
	public Client() {}
	
	public Client(ClientDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
	}

	public Client(Long id, String name, String email, String cpfOrCnpj, Integer type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.type = type;
	}
	
	public Client(Long id, String name, String email, String cpfOrCnpj, ClientType type) {
		this(id, name, email, cpfOrCnpj, type.getCod());
	}
	
	public Client(NewClientDTO dto) {
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.type = dto.getType();
		this.cpfOrCnpj = dto.getCpfOrCnpj();
		this.phones = new HashSet<String>(Arrays.asList(dto.getPhoneNumber01(), dto.getPhoneNumber02(), dto.getPhoneNumber03()));
		
		Address address = new Address();
		address.setCity(new City(dto.getIdCity()));
		address.setComplement(dto.getComplement());
		address.setNeighborhood(dto.getNeighborhood());
		address.setNumber(dto.getNumber());
		address.setStreet(dto.getStreet());
		address.setZipCode(dto.getZipCode());
		address.setClient(this);
		
		this.address.add(address);
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

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public ClientType getType() {
		return ClientType.fromCode(type);
	}

	public void setType(ClientType type) {
		this.type = type.getCod();
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
}
