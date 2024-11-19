package com.locati.webservice.domain.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.locati.webservice.services.validations.CPFouCNPJ;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class NewClientDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Length(min = 5, max = 120)
	private String name;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	@CPFouCNPJ
	private String cpfOrCnpj;
	private Integer type;
	
	@NotEmpty
	private String street;
	
	@NotEmpty
	private String number;
	private String complement;
	private String neighborhood;
	
	@NotEmpty
	private String zipCode;
	
	@NotEmpty
	private String phoneNumber01;
	private String phoneNumber02;
	private String phoneNumber03;
	private Long idCity;
	
	public NewClientDTO() {}
	
	

	public NewClientDTO(String name, String email,
			String cpfOrCnpj, Integer type, String street, String number, String complement, String neighborhood,
			String zipCode, String phoneNumber01, String phoneNumber02, String phoneNumber03, Long idCity) {
		super();
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.type = type;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.zipCode = zipCode;
		this.phoneNumber01 = phoneNumber01;
		this.phoneNumber02 = phoneNumber02;
		this.phoneNumber03 = phoneNumber03;
		this.idCity = idCity;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber01() {
		return phoneNumber01;
	}

	public void setPhoneNumber01(String phoneNumber01) {
		this.phoneNumber01 = phoneNumber01;
	}

	public String getPhoneNumber02() {
		return phoneNumber02;
	}

	public void setPhoneNumber02(String phoneNumber02) {
		this.phoneNumber02 = phoneNumber02;
	}

	public String getPhoneNumber03() {
		return phoneNumber03;
	}

	public void setPhoneNumber03(String phoneNumber03) {
		this.phoneNumber03 = phoneNumber03;
	}

	public Long getIdCity() {
		return idCity;
	}

	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}
	
	
}
